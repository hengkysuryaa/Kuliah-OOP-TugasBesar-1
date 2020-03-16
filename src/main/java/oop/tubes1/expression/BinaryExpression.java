package oop.tubes1.expression;

/**
 * BinaryExpression
 */
public abstract class BinaryExpression<T> implements Expression<T> {

    protected Expression<T> expression1, expression2;

    public BinaryExpression(Expression<T> expression1, Expression<T> expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public abstract T solve();

}