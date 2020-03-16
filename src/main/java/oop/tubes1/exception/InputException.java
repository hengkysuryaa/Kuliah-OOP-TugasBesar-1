package oop.tubes1.exception;

/**
 * InputException
 */
public abstract class InputException extends ExpressionException {

    private static final long serialVersionUID = 6750831914011758960L;

    public InputException(String message) {
        super(message);
    }

}