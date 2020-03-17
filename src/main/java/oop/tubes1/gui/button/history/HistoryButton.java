package oop.tubes1.gui.button.history;

import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.gui.button.CalculatorButton;

/**
 * HistoryButton
 */
public abstract class HistoryButton extends CalculatorButton {

    private static final long serialVersionUID = -3512592947907369531L;

    public HistoryButton(CalculatorApp app, String label) {
        super(app, label);
    }

}