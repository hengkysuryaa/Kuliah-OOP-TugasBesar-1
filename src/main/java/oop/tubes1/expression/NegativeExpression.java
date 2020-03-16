package oop.tubes1.expression;

/**
 * NegativeExpression
 */
public class NegativeExpression extends UnaryExpression<Double> {

    public NegativeExpression(Expression<Double> expression) {
        super(expression);
    }

    @Override
    public Double solve() {
        return -expression.solve();
    }

}