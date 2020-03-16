package oop.tubes1.expression;

/**
 * SubstractExpression
 */
public class SubstractExpression extends BinaryExpression<Double> {

    public SubstractExpression(Expression<Double> expression1, Expression<Double> expression2) {
        super(expression1, expression2);
    }

    @Override
    public Double solve() {
        return expression1.solve() - expression2.solve();
    }

}