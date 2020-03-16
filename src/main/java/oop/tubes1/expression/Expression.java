package oop.tubes1.expression;

import oop.tubes1.exception.expression.ExpressionException;

/**
 * Expression
 */
public interface Expression<T> {

    public T solve() throws ExpressionException;

}