package ca.bcit2522.Lab2.bam;

/**
 * Class to represent an invalid healing amount as a runtime exception.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class HealingException extends RuntimeException {

    /**
     * Constructor to build a HealingException based upon an illegal value.
     *
     * @param healingAmount healing amount value seen as illegal
     */
    public HealingException(final int healingAmount) {
        super("Negative healing is invalid. Heal amount: " + healingAmount);
    }

}
