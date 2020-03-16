package oop.tubes1.expression;

import oop.tubes1.exception.expression.DivisionByZeroExpressionException;

/**
 * DivisionExpression
 */
public class DivisionExpression extends BinaryExpression<Double> {

    public DivisionExpression(Expression<Double> expression1, Expression<Double> expression2) {
        super(expression1, expression2);
    }

    @Override
    public Double solve() {
        Double d1 = expression1.solve(), d2 = expression2.solve();
        if (d2 == 0d) {
            throw new DivisionByZeroExpressionException(d1);
        }
        return d1 / d2;
    }

}