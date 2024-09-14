package ca.bcit2522.Lab2.BAM;

/**
 * Class to represent an invalid damage as a runtime exception.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class DamageException extends RuntimeException {

    /**
     * Constructor to build a DamageException based upon an illegal value.
     *
     * @param damage damage value seen as illegal
     */
    public DamageException(final int damage) {
        super("Negative damage is invalid. Damage: " + damage);
    }

}
