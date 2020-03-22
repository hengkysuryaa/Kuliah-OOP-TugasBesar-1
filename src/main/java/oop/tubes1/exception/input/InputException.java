package oop.tubes1.exception.input;

/**
 * InputException
 */
public abstract class InputException extends RuntimeException {

    private static final long serialVersionUID = 6750831914011758960L;
    private String expression;

    public InputException(String message, String expression) {
        super(message + " Found on: " + expression);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

}