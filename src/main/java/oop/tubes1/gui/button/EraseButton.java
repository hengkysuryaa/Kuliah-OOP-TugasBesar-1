package oop.tubes1.gui.button;

import oop.tubes1.gui.CalculatorApp;

/**
 * EraseButton
 */
public class EraseButton extends CalculatorButton {

    private static final long serialVersionUID = -1688975348912982389L;

    public EraseButton(CalculatorApp app) {
        super(app, "Del");
    }

    @Override
    public void onClick() {
        app.getCalculatorDisplay().remove();
    }

}