package ca.bcit2522.Lab2.BAM;

/**
 * Class to check whether the dragon does not have enough firepower
 * @author Ben, Marcus, Andre
 * @version 1.0
 */
public class LowFirePowerException extends Exception {
    /**
     * creates an exception object for low firepower
     * @param message a message to the user
     */
    public LowFirePowerException(final String message) {
        super(message);
    }
}

