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
        
        if (app.textArea.getText().length() == 0 || app.textArea.getText().length() == 1)
        {
            app.textArea.setText("");
        }
        else
        {
            app.textArea.setText(app.textArea.getText().substring(0,app.textArea.getText().length()-1));
        }

    }

}