package ru.socionicasys.analyst;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Панель «Витал/Ментал/Суперид/Суперэго».
 */
public class MVPanel extends JPanel implements PropertyChangeListener, ItemListener {
	private final DocumentSelectionModel selectionModel;
	private final Map<String, JRadioButton> buttons;
	private final ButtonGroup buttonGroup;
	private final JButton clearButton;

	public MVPanel(DocumentSelectionModel selectionModel) {
		this.selectionModel = selectionModel;
		this.selectionModel.addPropertyChangeListener(this);

		buttons = new HashMap<String, JRadioButton>(4);
		buttons.put(AData.VITAL, new JRadioButton("Витал"));
		buttons.put(AData.MENTAL, new JRadioButton("Ментал"));
		buttons.put(AData.SUPERID, new JRadioButton("Супер-ИД"));
		buttons.put(AData.SUPEREGO, new JRadioButton("Супер-ЭГО"));

		buttonGroup = new ButtonGroup();
		for (Map.Entry<String, JRadioButton> entry : buttons.entrySet()) {
			String buttonKey = entry.getKey();
			JRadioButton button = entry.getValue();
			button.addItemListener(this);
			button.setActionCommand(buttonKey);
			buttonGroup.add(button);
		}

		clearButton = new JButton("Очистить");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection();
			}
		});

		Panel pp1 = new Panel();
		Panel pp2 = new Panel();
		Panel pp = new Panel();
		pp.setMinimumSize(new Dimension(200, 120));
		setMinimumSize(new Dimension(200, 120));
		setMaximumSize(new Dimension(200, 120));

		pp1.setLayout(new BoxLayout(pp1, BoxLayout.Y_AXIS));
		pp2.setLayout(new BoxLayout(pp2, BoxLayout.Y_AXIS));
		pp1.add(buttons.get(AData.VITAL));
		pp1.add(buttons.get(AData.MENTAL));
		pp2.add(buttons.get(AData.SUPERID));
		pp2.add(buttons.get(AData.SUPEREGO));
		pp.setLayout(new BoxLayout(pp, BoxLayout.X_AXIS));

		pp.add(pp1);
		pp.add(pp2);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(pp);
		add(clearButton);
		setBorder(new TitledBorder("Ментал/Витал"));

		updateView();
	}

	@Deprecated
	public String getMVSelection() {
		ButtonModel bm = buttonGroup.getSelection();
		if (bm == null) {
			return null;
		}
		return bm.getActionCommand();
	}

	@Deprecated
	public void setMV(String mv) {
		if (mv == null) {
			buttonGroup.clearSelection();
		} else if (buttons.containsKey(mv)) {
			buttonGroup.setSelected(buttons.get(mv).getModel(), true);
		}

		boolean enableClearButton = buttonGroup.getSelection() != null;
		clearButton.setEnabled(enableClearButton);
	}

	/**
	 * Обрабатывает изменение свойств в модели выделения, к которой привязана эта панель.
	 * Включает/отключает панель и меняет состояние элементов при изменениях в выделении.
	 *
	 * @param evt параметр не используется
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		updateView();
	}

	/**
	 * Обновляет элементы управления панели в соответствии со связанными данными из модели выделения.
	 */
	private void updateView() {
		String mv = selectionModel.getMV();
		boolean panelEnabled = !selectionModel.isEmpty() && !selectionModel.isMarkupEmpty();
		boolean selectionEnabled = panelEnabled && mv != null;

		for (JRadioButton button : buttons.values()) {
			button.setEnabled(panelEnabled);
		}
		clearButton.setEnabled(selectionEnabled);

		if (selectionEnabled) {
			JRadioButton selectedButton = buttons.get(mv);
			buttonGroup.setSelected(selectedButton.getModel(), true);
		} else {
			buttonGroup.clearSelection();
		}
	}

	/**
	 * Обрабатывает изменение в состоянии этой панели и отображает их на модель выделения,
	 * к которой панель привязана.
	 *
	 * @param e параметр не используется
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		ButtonModel selectedButtonModel = buttonGroup.getSelection();
		if (selectedButtonModel == null) {
			selectionModel.setMV(null);
		} else {
			selectionModel.setMV(selectedButtonModel.getActionCommand());
		}
	}
}