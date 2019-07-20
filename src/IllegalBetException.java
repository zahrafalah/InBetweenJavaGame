
/**
 * IllegalBetException
 * An
 * A customized error class that will call the superClass Method
 * to throw an error when the bet is not valid.
 *
 * @author Zahra Falah
 */
public class IllegalBetException extends Exception {

//Constructor that calls it's super class constructor
    public IllegalBetException(String errorMessage) {
        super(errorMessage);
    }
}
