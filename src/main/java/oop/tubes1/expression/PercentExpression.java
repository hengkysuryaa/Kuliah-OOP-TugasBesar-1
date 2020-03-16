package oop.tubes1.expression;

/**
 * PercentExpression
 */
public class PercentExpression extends UnaryExpression<Double> {

    public PercentExpression(Expression<Double> expression) {
        super(expression);
    }

    @Override
    public Double solve() {
        return expression.solve() / 100d;
    }

}