package oop.tubes1.gui.button;

import oop.tubes1.gui.CalculatorApp;

/**
 * EraseButton
 */
public class EraseButton extends CalculatorButton {

    private static final long serialVersionUID = -1688975348912982389L;

    public EraseButton(CalculatorApp app) {
        super(app, "<=");
    }

    @Override
    public void onClick() {

        if (app.getCalculatorDisplay().getText().length() == 0 || app.getCalculatorDisplay().getText().length() == 1) {
            app.getCalculatorDisplay().setText("");
        } else {
            app.getCalculatorDisplay().setText(app.getCalculatorDisplay().getText().substring(0,
                    app.getCalculatorDisplay().getText().length() - 1));
        }

    }

}