package ca.bcit2522.Lab2.BAM;


/**
 * Class to represent an invalid rage amount as a runtime exception.
 *
 * @author Andre
 * @version 1.0
 */
public class LowRageException extends RuntimeException {
    /**
     * creates an exception object
     * @param rageIsTooLow when rage is too low
     */
    public LowRageException(final String rageIsTooLow) {
        super(rageIsTooLow);
    }
}
