package oop.tubes1.expression;

/**
 * TerminalExpression
 */
public class TerminalExpression<T> implements Expression<T> {

    private T value;

    public TerminalExpression(T value) {
        this.value = value;
    }

    @Override
    public T solve() {
        return this.value;
    }

}