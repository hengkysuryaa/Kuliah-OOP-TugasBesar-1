package oop.tubes1.expression;

/**
 * MultiplicationExpression
 */
public class MultiplicationExpression extends BinaryExpression<Double> {

    public MultiplicationExpression(Expression<Double> expression1, Expression<Double> expression2) {
        super(expression1, expression2);
    }

    @Override
    public Double solve() {
        return expression1.solve() * expression2.solve();
    }

}