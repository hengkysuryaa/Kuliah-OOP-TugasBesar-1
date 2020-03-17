package oop.tubes1.gui.button.operand;

import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.gui.button.CalculatorButton;

/**
 * OperandButton
 */
public abstract class OperandButton extends CalculatorButton {

    private static final long serialVersionUID = 4565114734153058841L;
    protected char label;

    public OperandButton(CalculatorApp app, char label) {
        super(app, String.valueOf(label));
        this.label = label;
    }

    @Override
    public void onClick() {
        // TODO: Implement!

    }

}