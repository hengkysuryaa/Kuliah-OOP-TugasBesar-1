package oop.tubes1.gui.button.operator;

import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.gui.button.CalculatorButton;

/**
 * OperatorButton
 */
public class OperatorButton extends CalculatorButton {

    private static final long serialVersionUID = 5884057929289980719L;
    protected char label;

    public OperatorButton(CalculatorApp app, char label) {
        super(app, String.valueOf(label));
        this.label = label;
    }

    @Override
    public void onClick() {
        // TODO: Implement!

    }

}