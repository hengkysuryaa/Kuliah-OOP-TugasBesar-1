package oop.tubes1.expression;

/**
 * PowerExpression
 */
public class PowerExpression extends BinaryExpression<Double> {

    public PowerExpression(Expression<Double> expression1, Expression<Double> expression2) {
        super(expression1, expression2);
    }

    @Override
    public Double solve() {
        return Math.pow(expression1.solve(), expression2.solve());
    }

}