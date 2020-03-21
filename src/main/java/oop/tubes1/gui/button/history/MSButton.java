package oop.tubes1.gui.button.history;

import oop.tubes1.gui.CalculatorApp;

/**
 * MCButton
 */
public class MSButton extends HistoryButton {

    private static final long serialVersionUID = 7068404634251724319L;

    public MSButton(CalculatorApp app) {
        super(app, "MS");
    }

    @Override
    public void onClick() {
        app.getEquationButton().onClick();
        String result = app.getCalculatorDisplay().getText();
        app.getMemQueue().store(Double.parseDouble(result));
    }

}