package oop.tubes1.gui.button;

import oop.tubes1.gui.CalculatorApp;

import oop.tubes1.utils.ExpressionConverter;

import oop.tubes1.expression.Expression;

/**
 * EraseButton
 */
public class AnsButton extends CalculatorButton {

    private static final long serialVersionUID = -1688975348912982389L;

    public AnsButton(CalculatorApp app) {
        super(app, "Ans");
    }

    @Override
    public void onClick() {
        String eks = app.textArea.getText();
        ExpressionConverter<Expression<Double>> converter = new ExpressionConverter<>(eks);
        try {
            String result = Double.toString(converter.getExpression().solve());
            app.textArea.setText(result);
        } catch (Exception e) {
            app.textArea.setText("Invalid");
        }

    }

}