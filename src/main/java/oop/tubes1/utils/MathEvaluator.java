package oop.tubes1.utils;

import oop.tubes1.exception.input.InputException;
import oop.tubes1.expression.Expression;

/**
 * MathEvaluator
 */
public class MathEvaluator extends ExpressionConverter<Expression<Double>> {

    public MathEvaluator(String input) {
        super(input);
    }

    @Override
    public Expression<Double> getExpression() throws InputException {
        return null;
    }

}