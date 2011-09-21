package ru.socionicasys.analyst;

import ru.socionicasys.analyst.types.Aspect;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Панель выбора аспекта/блока/перевода.
 */
public final class AspectPanel extends ActivePanel {
	private Map<Aspect, JRadioButton> primaryAspectButtons;
	private Map<Aspect, JRadioButton> secondaryAspectButtons;
	private JRadioButton d;
	private JRadioButton aspect, block, jump;
	private ButtonGroup aspectGroup, secondAspectGroup, controlGroup;
	private JButton clearAspectSelection;

	public AspectPanel(DocumentSelectionModel selectionModel) {
		super(selectionModel);

		setMinimumSize(new Dimension(200, 270));
		setMaximumSize(new Dimension(200, 270));

		Panel pAspect = new Panel();
		pAspect.setLayout(new BoxLayout(pAspect, BoxLayout.Y_AXIS));
		pAspect.setPreferredSize(new Dimension(50, 200));
		pAspect.setMinimumSize(new Dimension(50, 200));

		aspectGroup = new ButtonGroup();
		primaryAspectButtons = new HashMap<Aspect, JRadioButton>();
		for (Aspect aspect : Aspect.values()) {
			JRadioButton button = new JRadioButton(aspect.getAbbreviation());
			button.setActionCommand(aspect.getAbbreviation());
			button.addItemListener(this);
			aspectGroup.add(button);
			pAspect.add(button);
			primaryAspectButtons.put(aspect, button);
		}

		Panel pAspect2 = new Panel();
		pAspect2.setLayout(new BoxLayout(pAspect2, BoxLayout.Y_AXIS));
		pAspect2.setPreferredSize(new Dimension(50, 200));
		pAspect2.setMinimumSize(new Dimension(50, 200));

		secondAspectGroup = new ButtonGroup();
		secondaryAspectButtons = new HashMap<Aspect, JRadioButton>();
		for (Aspect aspect : Aspect.values()) {
			JRadioButton button = new JRadioButton(aspect.getAbbreviation());
			button.setActionCommand(aspect.getAbbreviation());
			button.addItemListener(this);
			secondAspectGroup.add(button);
			pAspect2.add(button);
			secondaryAspectButtons.put(aspect, button);
		}

		aspect = new JRadioButton("Аспект");
		aspect.addItemListener(this);
		aspect.setActionCommand("aspect");
		block = new JRadioButton("Блок");
		block.addItemListener(this);
		block.setActionCommand("block");
		jump = new JRadioButton("Перевод");
		jump.addItemListener(this);
		jump.setActionCommand("jump");

		d = new JRadioButton("???");
		d.getModel().addItemListener(this);
		d.setActionCommand(AData.DOUBT);
		aspectGroup.add(d);

		controlGroup = new ButtonGroup();
		controlGroup.add(aspect);
		controlGroup.add(block);
		controlGroup.add(jump);

		clearAspectSelection = new JButton("Очистить");

		Panel pControl = new Panel();
		pControl.setLayout(new BoxLayout(pControl, BoxLayout.X_AXIS));
		pControl.setPreferredSize(new Dimension(50, 40));
		pControl.setMinimumSize(new Dimension(50, 40));
		pControl.add(aspect);
		pControl.add(block);
		pControl.add(jump);

		Panel pA = new Panel();
		pA.setLayout(new BoxLayout(pA, BoxLayout.X_AXIS));

		pA.add(pAspect);
		pA.add(pAspect2);

		Panel pB = new Panel();
		pB.setLayout(new BoxLayout(pB, BoxLayout.Y_AXIS));

		pB.add(new Panel());
		pB.add(clearAspectSelection);
		pB.add(new Panel());
		pB.add(d);
		pB.add(new Panel());

		setLayout(new BorderLayout());
		add(pControl, BorderLayout.NORTH);
		add(pA, BorderLayout.WEST);
		add(pB, BorderLayout.EAST);

		setBorder(new TitledBorder("Аспект/Блок"));

		aspectGroup.clearSelection();
		secondAspectGroup.clearSelection();
		controlGroup.clearSelection();

		clearAspectSelection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aspectGroup.clearSelection();
				secondAspectGroup.clearSelection();
				controlGroup.setSelected(aspect.getModel(), true);
			}
		});

		updateView();
	}

	private void setSecondAspectForBlock(String firstAspectName) {
		if (firstAspectName != null) {
			Aspect firstAspect = Aspect.byAbbreviation(firstAspectName);
			for (Map.Entry<Aspect, JRadioButton> entry : secondaryAspectButtons.entrySet()) {
				JRadioButton button = entry.getValue();
				Aspect buttonAspect = entry.getKey();
				button.setEnabled(firstAspect.isBlockWith(buttonAspect));
			}
		}
	}

	private void setSecondAspectForJump(String firstAspect) {
		if (firstAspect != null) {
			for (Map.Entry<Aspect, JRadioButton> entry : secondaryAspectButtons.entrySet()) {
				JRadioButton button = entry.getValue();
				String buttonAspect = entry.getKey().getAbbreviation();
				button.setEnabled(!buttonAspect.equals(firstAspect));
			}
		}
	}

	/**
	 * Обновляет элементы управления панели в соответствии со связанными данными из модели выделения.
	 */
	@Override
	protected void updateView() {
		boolean panelEnable = !selectionModel.isEmpty();

		for (Aspect buttonAspect : Aspect.values()) {
			primaryAspectButtons.get(buttonAspect).setEnabled(panelEnable);
			secondaryAspectButtons.get(buttonAspect).setEnabled(panelEnable);
		}

		d.setEnabled(panelEnable);
		aspect.setEnabled(panelEnable);
		block.setEnabled(panelEnable);
		jump.setEnabled(panelEnable);

		boolean markupEnable = panelEnable && !selectionModel.isMarkupEmpty();
		clearAspectSelection.setEnabled(markupEnable);
		
		if (!panelEnable) {
			aspectGroup.clearSelection();
			secondAspectGroup.clearSelection();
			controlGroup.clearSelection();
			return;
		}

		String firstAspect = selectionModel.getAspect();
		if (firstAspect == null) {
			aspectGroup.clearSelection();
			aspect.getModel().setSelected(true);
		} else if (AData.DOUBT.equals(firstAspect)) {
			d.getModel().setSelected(true);
			aspect.getModel().setSelected(true);
		} else {
			JRadioButton selectedButton = primaryAspectButtons.get(Aspect.byAbbreviation(firstAspect));
			selectedButton.getModel().setSelected(true);
		}

		String modifier = selectionModel.getModifier();
		if (AData.BLOCK.equals(modifier)) {
			block.getModel().setSelected(true);
			setSecondAspectForBlock(firstAspect);
		} else if (AData.JUMP.equals(modifier)) {
			jump.getModel().setSelected(true);
			setSecondAspectForJump(firstAspect);
		} else {
			aspect.getModel().setSelected(true);
			for (JRadioButton button : secondaryAspectButtons.values()) {
				button.setEnabled(false);
			}
		}

		String secondAspect = selectionModel.getSecondAspect();
		if (secondAspect == null) {
			secondAspectGroup.clearSelection();
		} else {
			secondaryAspectButtons.get(Aspect.byAbbreviation(secondAspect)).getModel().setSelected(true);
		}
	}

	/**
	 * Обновляет модель в соответствии с измененными в панели данными.
	 */
	@Override
	protected void updateModel() {
		ButtonModel aspectGroupSelection = aspectGroup.getSelection();
		if (aspectGroupSelection == null) {
			selectionModel.setAspect(null);
		} else {
			String firstAspect = aspectGroupSelection.getActionCommand();
			selectionModel.setAspect(firstAspect);
		}

		ButtonModel secondAspectGroupSelection = secondAspectGroup.getSelection();
		if (secondAspectGroupSelection == null) {
			selectionModel.setSecondAspect(null);
		} else {
			String secondAspect = secondAspectGroupSelection.getActionCommand();
			selectionModel.setSecondAspect(secondAspect);
		}

		ButtonModel controlGroupSelection = controlGroup.getSelection();
		String modifier = "";
		if (controlGroupSelection == null) {
			modifier = null;
		} else {
			String controlCommand = controlGroupSelection.getActionCommand();
			if ("block".equals(controlCommand)) {
				modifier = AData.BLOCK;
			} else if ("jump".equals(controlCommand)) {
				modifier = AData.JUMP;
			} else {
				modifier = null;
			}
		}
		selectionModel.setModifier(modifier);
	}
}