package ca.bcit2522.Lab2.bam;

/**
 * Class to represent an invalid healing amount as a runtime exception.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class LowManaException extends Exception {
    /**
     * creates an exception object
     * @param manaPoints current mana points
     */
    public LowManaException(final int manaPoints) {
        super("You don't have enough mana to cast a spell. MP: " + manaPoints);
    }
}
