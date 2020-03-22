package oop.tubes1.exception.input;

/**
 * InvalidCommaException
 */
public class CommaInputException extends InputException {

    private static final long serialVersionUID = -8496346278328736534L;

    public CommaInputException(String expression) {
        super("The comma is invalid!", expression);
    }

}