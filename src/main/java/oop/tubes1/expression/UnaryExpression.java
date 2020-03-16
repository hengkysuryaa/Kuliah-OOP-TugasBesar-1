package oop.tubes1.expression;

/**
 * UnaryExpression
 */
public abstract class UnaryExpression<T> implements Expression<T> {

    protected Expression<T> expression;

    public UnaryExpression(Expression<T> expression) {
        this.expression = expression;
    }

    public abstract T solve();

}