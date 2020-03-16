package oop.tubes1.exception.expression;

/**
 * ExpressionException
 */
public abstract class ExpressionException extends RuntimeException {

    private static final long serialVersionUID = -1618634428588372563L;

    public ExpressionException(String message) {
        super(message);
    }

}