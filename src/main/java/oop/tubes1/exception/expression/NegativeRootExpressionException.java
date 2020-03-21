package oop.tubes1.exception.expression;

/**
 * NegativeRootException
 */
public class NegativeRootExpressionException extends ExpressionException {

    private static final long serialVersionUID = 5229703741375307595L;

    public NegativeRootExpressionException(Double number) {
        super("Root expression can't have negative number! Found on: √" + number);
    }

}