package oop.tubes1.utils;

import oop.tubes1.exception.input.InputException;
import oop.tubes1.expression.Expression;

/**
 * ExpressionConverter
 */
public abstract class ExpressionConverter<T extends Expression<?>> {

    protected String input;

    public ExpressionConverter(String input) {
        this.input = input;
    }

    public abstract T getExpression() throws InputException;

}