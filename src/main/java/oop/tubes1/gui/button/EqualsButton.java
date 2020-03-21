package oop.tubes1.gui.button;

import oop.tubes1.exception.expression.ExpressionException;
import oop.tubes1.exception.input.InputException;
import oop.tubes1.gui.CalculatorApp;
import oop.tubes1.utils.MathEvaluator;

/**
 * EraseButton
 */
public class EqualsButton extends CalculatorButton {

    private static final long serialVersionUID = -1688975348912982389L;

    public EqualsButton(CalculatorApp app) {
        super(app, "=");
    }

    @Override
    public void onClick() {
        String eks = app.getCalculatorDisplay().getText();
        MathEvaluator converter = new MathEvaluator(eks);
        try {
            String result = Double.toString(converter.getExpression().solve());
            app.getCalculatorDisplay().setText(result);
            app.setAnsValue(Double.parseDouble(result));
        } catch (InputException e) {
            app.getCalculatorDisplay().setText(e.getMessage());
        } catch (ExpressionException e) {
            app.getCalculatorDisplay().setText(e.getMessage());
        } catch (Exception e) {
            app.getCalculatorDisplay().setText("Invalid input!");
            e.printStackTrace();
        }

    }

}