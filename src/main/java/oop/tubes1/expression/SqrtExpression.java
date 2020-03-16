package oop.tubes1.expression;

import oop.tubes1.exception.expression.NegativeRootExpressionException;

/**
 * SqrtExpression
 */
public class SqrtExpression extends UnaryExpression<Double> {

    public SqrtExpression(Expression<Double> expression) {
        super(expression);
    }

    @Override
    public Double solve() {
        Double d = expression.solve();
        if (d < 0) {
            throw new NegativeRootExpressionException(d);
        }
        return Math.sqrt(d);
    }

}