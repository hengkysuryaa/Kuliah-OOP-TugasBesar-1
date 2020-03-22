package oop.tubes1.gui.button.history;

import oop.tubes1.gui.CalculatorApp;

/**
 * MCButton
 */
public class MRButton extends HistoryButton {

    private static final long serialVersionUID = 7068404634251724319L;

    public MRButton(CalculatorApp app) {
        super(app, "MR");
    }

    @Override
    public void onClick() {
        Double recallVal = app.getMemoryDisplay().recall();
        String recallString;
        if (recallVal != null) {
            recallString = Double.toString(recallVal);
        } else {
            recallString = "";
        }
        app.getCalculatorDisplay().append(recallString);
    }

}