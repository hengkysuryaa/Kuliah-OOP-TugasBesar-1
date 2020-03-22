package oop.tubes1.exception.input;

/**
 * CommaInputException
 */
public class CommaInputException extends InputException {

    private static final long serialVersionUID = 4409159156814470861L;

    public CommaInputException(String expression) {
        super("The comma is invalid!", expression);
    }

}