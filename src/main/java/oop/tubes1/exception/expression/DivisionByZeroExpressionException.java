package oop.tubes1.exception.expression;

/**
 * DivisionByZeroException
 */
public class DivisionByZeroExpressionException extends ExpressionException {

    private static final long serialVersionUID = -4879576230035111990L;

    public DivisionByZeroExpressionException(Double number) {
        super(number, "Division by zero is undefined! Found on: " + number + "/0");
    }

}