package ru.socionicasys.analyst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Отслеживает и синхронизирует изменения в модели выделения для документа, самом документе,
 * и в положении курсора в текстовом поле.
 */
public class DocumentSelectionConnector implements PropertyChangeListener, CaretListener, TreeSelectionListener {
	/**
	 * Текстовое поле, с которым связан коннектор.
	 */
	private final TextPane textPane;

	/**
	 * Модель выделения, с которой связан коннектор.
	 */
	private final DocumentSelectionModel selectionModel;

	private static final Logger logger = LoggerFactory.getLogger(DocumentSelectionConnector.class);

	/**
	 * Создает объект-коннектор, связывающий текстовое поле и модель выделения в документе.
	 * 
	 * @param textPane текстовое поле, выделение в котором отображается в модель
	 * @param selectionModel модель выделения, изменения из которой будут транслироваться в документ,
	 * связанный с текстовым полем
	 */
	public DocumentSelectionConnector(TextPane textPane, DocumentSelectionModel selectionModel) {
		this.textPane = textPane;
		this.textPane.addCaretListener(this);
		this.selectionModel = selectionModel;
		this.selectionModel.addPropertyChangeListener(this);
	}

	/**
	 * Метод вызывается при изменениях в модели текущего выделения.
	 *
	 * @param evt парметр игнорируется, обновленные данные берутся непосредственно из модели
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (!selectionModel.isInitialized()) {
			return;
		}

		ASection currentSection = getCurrentSection(selectionModel.getStartOffset(), selectionModel.getEndOffset());
		if (currentSection == null) {
			return;
		}

		ADocument document = textPane.getDocument();
		AData newMarkup = selectionModel.getMarkupData();
		AData oldMarkup = document.getAData(currentSection);
		if (oldMarkup == null) {
			if (newMarkup != null) {
				// Новая отметка в документе
				document.addASection(currentSection, newMarkup);
			}
		} else if (newMarkup == null) {
			// Удаление старой отметки
			document.removeASection(currentSection);
		} else if (!newMarkup.equals(oldMarkup)) {
			// Обновление данных в существующей отметке
			document.updateASection(currentSection, newMarkup);
		}
	}

	/**
	 * Метод вызывается при перемещении курсора или смене выделения в текстовом поле.
	 * 
	 * @param e текущее положение курсора и выделения в текстовом поле
	 */
	@Override
	public void caretUpdate(CaretEvent e) {
		int dot = e.getDot();
		int mark = e.getMark();
		logger.trace("caretUpdate: {}, {}", dot, mark);

		selectionModel.setInitialized(false);

		int startOffset = Math.min(dot, mark);
		int endOffset = Math.max(dot, mark);
		selectionModel.setStartOffset(startOffset);
		selectionModel.setEndOffset(endOffset);

		ASection currentSection = getCurrentSection(startOffset, endOffset);
		if (currentSection == null) {
			selectionModel.setMarkupData(null);
		} else {
			ADocument document = textPane.getDocument();
			AData currentMarkupData = document.getAData(currentSection);
			selectionModel.setMarkupData(currentMarkupData);
		}

		selectionModel.setInitialized(true);
	}

	/**
	 * Возвращает интервал в документе, выделенный в данный момент курсором,
	 * {@code null} если в документе сейчас нет активного выделения.
	 *
	 * @param startOffset позиция начала выделения
	 * @param endOffset позиция конца выделения
	 * @return выделенный в документе интервал
	 */
	private ASection getCurrentSection(int startOffset, int endOffset) {
		if (startOffset == endOffset) {
			return null;
		}
		
		ADocument document = textPane.getDocument();
		try {
			return new ASection(document, startOffset, endOffset);
		} catch (BadLocationException e) {
			logger.error("Invalid document positions: {}, {}", startOffset, endOffset);
			logger.error("Exception thrown: ", e);
			return null;
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode leafNode = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
		Object leafObject = leafNode.getUserObject();

		int index = 0;

		if (leafObject instanceof EndNodeObject) {
			index = ((EndNodeObject) leafObject).getOffset();
		} else {
			String quote = leafObject.toString();
			if (quote != null && quote.startsWith("#")) {
				String indexStr = quote.substring(1, quote.indexOf("::"));
				index = Integer.parseInt(indexStr);
			}
		}
		//////////////test for text positioning in scroll pane////////////////////////
		JViewport viewport = (JViewport) textPane.getParent();

		ADocument document = textPane.getDocument();
		ASection currentASection = document.getASectionThatStartsAt(index);
		if (currentASection != null) {
			int offset = currentASection.getMiddleOffset();
			int start = currentASection.getStartOffset();
			int end = currentASection.getEndOffset();

			textPane.getCaret().setDot(end);
			textPane.getCaret().moveDot(start);

			try {
				viewport.scrollRectToVisible(textPane.modelToView(offset));
				textPane.grabFocus();
			} catch (BadLocationException e1) {
				logger.error("Error setting model to view :: bad location", e1);
			}
		}
	}
}
