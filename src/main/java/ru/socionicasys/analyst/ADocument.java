package ru.socionicasys.analyst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.text.*;
import javax.swing.undo.*;

@SuppressWarnings({"NonSerializableFieldInSerializableClass", "serial"})
public class ADocument extends DefaultStyledDocument implements DocumentListener {
	public static final String DEFAULT_TITLE = "Новый документ";
	// document's properties names
	public static final String TitleProperty1 = "Документ:";
	public static final String ExpertProperty = "Эксперт:";
	public static final String ClientProperty = "Типируемый:";
	public static final String DateProperty = "Дата:";
	public static final String CommentProperty = "Комментарий:";

	private Map<ASection, AData> aDataMap;
	private Collection<ADocumentChangeListener> listeners;
	public final SimpleAttributeSet defaultStyle;
	public final SimpleAttributeSet defaultSectionAttributes;

	private CompoundEdit currentCompoundEdit;
	private int currentCompoundDepth;

	/**
	 * Информация о соответствиях/несоответствиях ТИМам
	 */
	private final MatchMissModel matchMissModel;

	/**
	 * Файл, с которым связан данный документ, и в который будет по умолчанию происходить сохранение документа
	 * {@code null}, если документ не привязан к какому-либо файлу.
	 */
	private File associatedFile;

	private static final Logger logger = LoggerFactory.getLogger(ADocument.class);

	/**
	 * Сравнивает две ASection исходя из их близости к определенному положению в документе.
	 */
	private static final class SectionDistanceComparator implements Comparator<ASection> {
		private final int targetPosition;

		/**
		 * @param targetPosition позиция в документе. Секции, центры которых близки к этой позиции
		 * будут выше при сортировке.
		 */
		private SectionDistanceComparator(int targetPosition) {
			this.targetPosition = targetPosition;
		}

		@Override
		public int compare(ASection o1, ASection o2) {
			int midDistance1 = Math.abs(targetPosition - o1.getMiddleOffset());
			int midDistance2 = Math.abs(targetPosition - o2.getMiddleOffset());
			if (midDistance1 != midDistance2) {
				return midDistance1 - midDistance2;
			}
			return -(o1.getStartOffset() - o2.getStartOffset());
		}
	}

	public ADocument() {
		logger.trace("ADocument(): entering");
		addDocumentListener(this);

		//style of general text
		defaultStyle = new SimpleAttributeSet();
		defaultStyle.addAttribute(StyleConstants.FontSize, Integer.valueOf(16));
		defaultStyle.addAttribute(StyleConstants.Background, Color.white);
		//style of a section with mark-up
		defaultSectionAttributes = new SimpleAttributeSet();
		defaultSectionAttributes.addAttribute(StyleConstants.Background, Color.decode("#E0ffff"));

		currentCompoundDepth = 0;

		matchMissModel = new MatchMissModel();
		addADocumentChangeListener(matchMissModel);

		aDataMap = new HashMap<ASection, AData>();

		putProperty(TitleProperty, DEFAULT_TITLE);
		putProperty(ExpertProperty, "");
		putProperty(ClientProperty, "");
		Date now = new Date();
		putProperty(DateProperty, now.toLocaleString());
		putProperty(CommentProperty, "");

		setCharacterAttributes(0, 1, defaultStyle, true);
		fireADocumentChanged();
		logger.trace("ADocument(): leaving");
	}

	/**
	 * Находит блок (ASection), который содержит заданную позицию. Если таких блоков несколько, выбирается тот,
	 * центральная часть которого лежит ближе всего к этой позиции. Среди блоков, центры которых лежат на одном
	 * расстоянии, выбирается блок максимальной вложенности.
	 * @param pos позиция в документе, для которой нужно найти блок
	 * @return блок, содержащий заданную позицию, или null, если такого нет
	 */
	public ASection getASection(int pos) {
		logger.trace("getASection(): entering, pos={}", pos);
		Collection<ASection> results = new ArrayList<ASection>();
		for (ASection as : aDataMap.keySet()) {
			if (as.containsOffset(pos)) {
				results.add(as);
			}
		}
		if (results.isEmpty()) {
			logger.trace("getASection(): leaving, no section found");
			return null;
		}

		ASection matchingSection = Collections.min(results, new SectionDistanceComparator(pos));
		logger.trace("getASection(): leaving, found ASection {}", matchingSection);
		return matchingSection;
	}

	public ASection getASectionThatStartsAt(int startOffset) {
		logger.trace("getASectionThatStartsAt(): entering, startOffset={}", startOffset);
		for (ASection section : aDataMap.keySet()) {
			if (section.getStartOffset() == startOffset) {
				logger.trace("getASectionThatStartsAt(): leaving, found ASection {}", section);
				return section;
			}
		}
		logger.trace("getASectionThatStartsAt(): leaving, no section found");
		return null;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	}

	@Override
	protected void insertUpdate(DefaultDocumentEvent chng, AttributeSet attr) {
		logger.trace("insertUpdate(): entering, chng={}, attr={}", chng, attr);
		//if insert is on the section end - do not extend the section to the inserted text
		int offset = chng.getOffset();
		int length = chng.getLength();

		Iterator<ASection> sectionIterator = aDataMap.keySet().iterator();
		Map<ASection, AData> tempMap = new HashMap<ASection, AData>();
		while (sectionIterator.hasNext()) {
			ASection sect = sectionIterator.next();
			if (sect.getEndOffset() == offset + length) {
				int start = sect.getStartOffset();
				AData aData = aDataMap.get(sect);
				sectionIterator.remove();
				try {
					tempMap.put(new ASection(this, start, offset), aData);
				} catch (BadLocationException e) {
					logger.error("Invalid position for ASection", e);
				}
			}
		}

		aDataMap.putAll(tempMap);

		super.insertUpdate(chng, defaultStyle);
		logger.trace("insertUpdate(): leaving");
	}

	@Override
	protected void removeUpdate(DefaultDocumentEvent chng) {
		logger.trace("removeUpdate(): entering, chng={}", chng);
		startCompoundEdit();

		int offset = chng.getOffset();
		removeCleanup(offset, offset + chng.getLength());
		super.removeUpdate(chng);

		fireADocumentChanged();
		endCompoundEdit();
		logger.trace("removeUpdate(): leaving");
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
	}

	public void removeCleanup(int start, int end) {
		logger.trace("removeCleanup(): entering, start={}, end={}", start, end);
		// проверяет не нужно ли удалить схлопнувшиеся сегменты
		boolean foundCollapsed = false;
		Collection<ASection> toRemove = new ArrayList<ASection>();
		for (ASection sect : aDataMap.keySet()) {
			if (sect.getStartOffset() > start && sect.getStartOffset() <= end &&
				sect.getEndOffset() > start && sect.getEndOffset() <= end) {
				toRemove.add(sect);
				foundCollapsed = true;
			}
		}

		for (ASection section : toRemove) {
			removeASection(section);
		}
		if (foundCollapsed) {
			fireADocumentChanged();
		}
		logger.trace("removeCleanup(): leaving");
	}

	public AData getAData(ASection section) {
		return aDataMap.get(section);
	}

	public void removeASection(ASection section) {
		logger.trace("removeASection(): entering, section={}", section);
		if (section == null) {
			return;
		}

		startCompoundEdit();

		AData data = aDataMap.get(section);
		aDataMap.remove(section);

		int startOffset = section.getStartOffset();
		int endOffset = section.getEndOffset();
		setCharacterAttributes(startOffset, endOffset - startOffset, defaultStyle, false);

		fireUndoableEditUpdate(new UndoableEditEvent(this, new ASectionDeletionEdit(section, data)));
		fireADocumentChanged();

		endCompoundEdit();
		logger.trace("removeASection(): leaving");
	}

	public void updateASection(ASection aSection, AData data) {
		logger.trace("updateASection(): entering, aSection={}, data={}", aSection, data);
		startCompoundEdit();
		AData oldData = aDataMap.get(aSection);
		aDataMap.remove(aSection);
		aDataMap.put(aSection, data);

		fireUndoableEditUpdate(new UndoableEditEvent(this, new ASectionChangeEdit(aSection, oldData, data)));
		fireADocumentChanged();
		endCompoundEdit();
		logger.trace("updateASection(): leaving");
	}

	public void addASection(ASection aSection, AData data) {
		logger.trace("addASection(): entering, aSection={}, data={}", aSection, data);
		startCompoundEdit();
		int startOffset = aSection.getStartOffset();
		int endOffset = aSection.getEndOffset();

		setCharacterAttributes(startOffset, endOffset - startOffset, defaultSectionAttributes, false);
		aDataMap.put(aSection, data);

		fireUndoableEditUpdate(new UndoableEditEvent(this, new ASectionAdditionEdit(aSection, data)));
		fireADocumentChanged();
		endCompoundEdit();
		logger.trace("addASection(): leaving");
	}

	public void addADocumentChangeListener(ADocumentChangeListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<ADocumentChangeListener>();
		}
		listeners.add(listener);
	}

	public void removeADocumentChangeListener(ADocumentChangeListener listener) {
		if (listeners != null) {
			listeners.remove(listener);
		}
	}

	public void fireADocumentChanged() {
		logger.trace("fireADocumentChanged(): entering");
		if (listeners == null) {
			logger.trace("fireADocumentChanged(): leaving, no listeners to notify");
			return;
		}
		for (ADocumentChangeListener listener : listeners) {
			listener.aDocumentChanged(this);
		}
		logger.trace("fireADocumentChanged(): leaving");
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
	}

	public Map<ASection, AData> getADataMap() {
		return aDataMap;
	}

	/**
	 * Группирует последующие изменения в документе в один {@link CompoundEdit}. Группы могут вкладываться друг
	 * в друга, но реальная группировка изменений происходит только в группах первого уровня.
	 */
	private void startCompoundEdit() {
		logger.trace("startCompoundEdit(): entering");
		if (currentCompoundDepth == 0) {
			currentCompoundEdit = new CompoundEdit();
		}
		currentCompoundDepth++;
		logger.trace("startCompoundEdit(): leaving. Edit level {} ({})", currentCompoundDepth,
				currentCompoundEdit.getPresentationName());
	}

	/**
	 * Оканчивает группу изменений, начатую {@link #startCompoundEdit()}.
	 */
	private void endCompoundEdit() {
		logger.trace("endCompoundEdit(): entering. Edit level {}, ({})", currentCompoundDepth,
				currentCompoundEdit.getPresentationName());
		currentCompoundDepth--;
		if (currentCompoundDepth > 0) {
			return;
		}
		currentCompoundEdit.end();
		super.fireUndoableEditUpdate(new UndoableEditEvent(this, currentCompoundEdit));
		logger.trace("endCompoundEdit(): leaving");
	}

	@Override
	protected void fireUndoableEditUpdate(UndoableEditEvent e) {
		logger.trace("fireUndoableEditUpdate(): entering, event = {}", e);
		if (currentCompoundDepth > 0) {
			currentCompoundEdit.addEdit(e.getEdit());
		} else {
			super.fireUndoableEditUpdate(e);
		}
		logger.trace("fireUndoableEditUpdate(): leaving");
	}

	/**
	 * Описывает операцию добавления в документ новой секции с разметкой.
	 */
	@SuppressWarnings("SerializableNonStaticInnerClassWithoutSerialVersionUID")
	private class ASectionAdditionEdit extends AbstractUndoableEdit {
		private final ASection section;
		private final AData data;

		private ASectionAdditionEdit(ASection section, AData data) {
			this.section = section;
			this.data = data;
		}

		@Override
		public void undo() throws CannotUndoException {
			super.undo();
			aDataMap.remove(section);
			fireADocumentChanged();
		}

		@Override
		public void redo() throws CannotRedoException {
			super.redo();
			aDataMap.put(section, data);
			fireADocumentChanged();
		}

		@Override
		public String getUndoPresentationName() {
			return "Отменить вставку сегмента анализа";
		}

		@Override
		public String getPresentationName() {
			return "Вставка сегмента анализа";
		}

		@Override
		public String getRedoPresentationName() {
			return "Вернуть вставку сегмента анализа";
		}
	}

	/**
	 * Описывает операцию удаления из документа секции с разметкой.
	 */
	@SuppressWarnings("SerializableNonStaticInnerClassWithoutSerialVersionUID")
	private class ASectionDeletionEdit extends AbstractUndoableEdit {
		private final ASection section;
		private final AData data;

		private ASectionDeletionEdit(ASection section, AData data) {
			this.section = section;
			this.data = data;
		}
		@Override
		public void undo() throws CannotUndoException {
			super.undo();
			aDataMap.put(section, data);
			fireADocumentChanged();
		}

		@Override
		public void redo() throws CannotRedoException {
			super.redo();
			aDataMap.remove(section);
			fireADocumentChanged();
		}

		@Override
		public String getUndoPresentationName() {
			return "Отменить очистку сегмента анализа";
		}

		@Override
		public String getPresentationName() {
			return "Очистка сегмента анализа";
		}

		@Override
		public String getRedoPresentationName() {
			return "Вернуть очитску сегмента анализа";
		}
	}

	/**
	 * Описывает операцию обновления данных в разметке одной из секций документа.
	 */
	@SuppressWarnings("SerializableNonStaticInnerClassWithoutSerialVersionUID")
	private class ASectionChangeEdit extends AbstractUndoableEdit {
		private final ASection section;
		private final AData oldData;
		private AData newData;

		private ASectionChangeEdit(ASection section, AData oldData, AData newData) {
			this.section = section;
			this.oldData = oldData;
			this.newData = newData;
		}

		@Override
		public void undo() throws CannotUndoException {
			super.undo();
			aDataMap.remove(section);
			aDataMap.put(section, oldData);
			fireADocumentChanged();
		}

		@Override
		public void redo() throws CannotRedoException {
			super.redo();
			aDataMap.remove(section);
			aDataMap.put(section, newData);
			fireADocumentChanged();
		}

		@Override
		public String getUndoPresentationName() {
			return "Отменить редактирование сегмента анализа";
		}

		@Override
		public String getPresentationName() {
			return "Редактирование сегмента анализа";
		}

		@Override
		public String getRedoPresentationName() {
			return "Вернуть редактирование сегмента анализа";
		}

		@Override
		public boolean addEdit(UndoableEdit anEdit) {
			if (anEdit instanceof ASectionChangeEdit && ((ASectionChangeEdit) anEdit).section.equals(section)) {
				newData = ((ASectionChangeEdit) anEdit).newData;
				return true;
			} else {
				return super.addEdit(anEdit);
			}
		}

		@Override
		public boolean replaceEdit(UndoableEdit anEdit) {
			if (anEdit instanceof ASectionChangeEdit && ((ASectionChangeEdit) anEdit).section.equals(section)) {
				newData = ((ASectionChangeEdit) anEdit).newData;
				return true;
			} else {
				return super.replaceEdit(anEdit);
			}
		}
	}

	public ADocumentFragment getADocFragment(int offset, int length) {
		logger.trace("getADocFragment(): entering, offset={}, length={}", offset, length);
		int selectionEnd = offset + length;
		String text;
		Map<DocSection, AttributeSet> styleMap = new HashMap<DocSection, AttributeSet>();
		Map<DocSection, AData> docMap = new HashMap<DocSection, AData>();

		try {
			text = getText(offset, length);

			//putting styles to a HashMap
			int styleRunStart = offset;
			AttributeSet currentSet = null;
			for (int i = offset; i <= offset + length; i++) {
				Element element = getCharacterElement(i);
				AttributeSet attributeSet = element.getAttributes();
				if (currentSet == null) {
					currentSet = attributeSet;
				}
				if (!attributeSet.isEqual(currentSet) || i == selectionEnd) {
					styleMap.put(new DocSection(styleRunStart - offset, i - offset),
						new SimpleAttributeSet(currentSet));
					currentSet = attributeSet;
					styleRunStart = i;
				}
			}

			//putting AData to a HashMap
			if (aDataMap != null) {
				for (Entry<ASection, AData> dataEntry : aDataMap.entrySet()) {
					int secSt = dataEntry.getKey().getStartOffset();
					int secEnd = dataEntry.getKey().getEndOffset();

					if (secSt >= offset && secEnd <= selectionEnd) {
						docMap.put(new DocSection(secSt - offset, secEnd - offset), dataEntry.getValue());
					}
					if (secSt < offset && secEnd > selectionEnd) {
						docMap.put(new DocSection(0, length), dataEntry.getValue());
					}
					if (secSt < offset && secEnd < selectionEnd && secEnd > offset) {
						docMap.put(new DocSection(0, secEnd - offset), dataEntry.getValue());
					}
					if (secSt > offset && secSt < selectionEnd && secEnd > selectionEnd) {
						docMap.put(new DocSection(secSt - offset, length), dataEntry.getValue());
					}
				}
			}
		} catch (BadLocationException e) {
			logger.error("Error in getADocFragment()", e);
			logger.trace("getADocFragment(): leaving");
			return null;
		}

		logger.trace("getADocFragment(): leaving");
		return new ADocumentFragment(text, styleMap, docMap);
	}

	public void pasteADocFragment(int position, ADocumentFragment fragment) {
		logger.trace("pasteADocFragment(): entering, position={}, fragment={}", position, fragment);
		// inserting plain text
		try {
			String text = fragment.getText();
			insertString(position, text, defaultStyle);
		} catch (BadLocationException e) {
			logger.error("Invalid document position {} for pasting text", position, e);
			logger.trace("pasteADocFragment(): leaving");
			return;
		}

		// inserting styles
		Map<DocSection, AttributeSet> styleMap = fragment.getStyleMap();
		for (Entry<DocSection, AttributeSet> entry : styleMap.entrySet()) {
			DocSection section = entry.getKey();
			AttributeSet style = entry.getValue();
			setCharacterAttributes(position + section.getStart(), section.getLength(), style, true);
		}

		// inserting AData
		Map<DocSection, AData> fragMap = fragment.getADataMap();
		for (Entry<DocSection, AData> entry : fragMap.entrySet()) {
			DocSection section = entry.getKey();
			AData data = entry.getValue();
			try {
				ASection aSection = new ASection(this, position + section.getStart(), position + section.getEnd());
				aDataMap.put(aSection, data);
			} catch (BadLocationException e) {
				logger.error("Invalid position for ASection", e);
			}
		}
		logger.trace("pasteADocFragment(): leaving");
	}

	/**
	 * Добавляет содержимое из документа anotherDocument в конец данного документа.
	 * @param anotherDocument документ, содержимое которого нужно добавить.
	 */
	public void appendDocument(ADocument anotherDocument) {
		logger.trace("appendDocument(): entering, anotherDocument={}", anotherDocument);
		List<ElementSpec> specs = new ArrayList<ElementSpec>();
		ElementSpec startSpec = new ElementSpec(new SimpleAttributeSet(), ElementSpec.StartTagType);
		specs.add(startSpec);
		visitElements(anotherDocument.getDefaultRootElement(), specs, false);
		ElementSpec endSpec = new ElementSpec(new SimpleAttributeSet(), ElementSpec.EndTagType);
		specs.add(endSpec);

		ElementSpec[] arr = new ElementSpec[specs.size()];
		specs.toArray(arr);
		int documentLength = getLength();
		try {
			insert(documentLength, arr);
		} catch (BadLocationException e) {
			logger.error("Error while appending to document");
		}

		for (Entry<ASection, AData> entry : anotherDocument.aDataMap.entrySet()) {
			ASection sourceSection = entry.getKey();
			try {
				ASection destinationSection = new ASection(this,
						sourceSection.getStartOffset() + documentLength,
						sourceSection.getEndOffset() + documentLength);
				aDataMap.put(destinationSection, entry.getValue());
			} catch (BadLocationException e) {
				logger.error("Invalid position for ASection", e);
			}
		}

		StringBuilder builder = new StringBuilder(getProperty(ExpertProperty).toString());
		builder.append("; ");
		builder.append(anotherDocument.getProperty(ExpertProperty));
		getDocumentProperties().put(ExpertProperty, builder.toString());

		fireADocumentChanged();
		logger.trace("appendDocument(): leaving");
	}

	/**
	 * Проходится по элементу и всем его дочерним элементам, собирая всю информацию в список ElementSpec-ов.
	 * @param element элемент, с которого начинается обход
	 * @param specs список, в который будут добавлены описания элементов
	 * @param includeRoot добавлять ли в описание теги открытия/закрытия начального элемента
	 */
	private static void visitElements(Element element, List<ElementSpec> specs, boolean includeRoot) {
		logger.trace("visitElements(): entering, element={}, specs={}, includeRoot={}",
				new Object[]{element, specs, includeRoot});
		if (element.isLeaf()) {
			try {
				String elementText = element.getDocument().getText(element.getStartOffset(),
						element.getEndOffset() - element.getStartOffset());
				specs.add(new ElementSpec(element.getAttributes(), ElementSpec.ContentType,
						elementText.toCharArray(), 0, elementText.length()));
			} catch (BadLocationException e) {
				logger.error("Error while traversing document");
			}
		}
		else {
			if (includeRoot) {
				specs.add(new ElementSpec(element.getAttributes(), ElementSpec.StartTagType));
			}
			for (int i = 0; i < element.getElementCount(); i++) {
				visitElements(element.getElement(i), specs, true);
			}

			if (includeRoot) {
				specs.add(new ElementSpec(element.getAttributes(), ElementSpec.EndTagType));
			}
		}
		logger.trace("visitElements(): leaving");
	}

	/**
	 * @return объект, описывающий (не)соответствия всем ТИМамы
	 */
	public MatchMissModel getMatchMissModel() {
		return matchMissModel;
	}

	/**
	 * Возвращает файл, связанный с данным документом.
	 * 
	 * @return файл, в который будет по умолчанию происходить сохранение документа
	 */
	public File getAssociatedFile() {
		return associatedFile;
	}

	/**
	 * Задает файл, связанный с данным документом.
	 *
	 * @param associatedFile файл, в который будет по умолчанию происходить сохранение документа
	 */
	public void setAssociatedFile(File associatedFile) {
		this.associatedFile = associatedFile;
	}
}
