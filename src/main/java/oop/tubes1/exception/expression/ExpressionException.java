package oop.tubes1.exception.expression;

/**
 * ExpressionException
 */
public abstract class ExpressionException extends RuntimeException {

    private static final long serialVersionUID = -1618634428588372563L;
    private Double number;

    public ExpressionException(Double number, String message) {
        super(message);
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }

}