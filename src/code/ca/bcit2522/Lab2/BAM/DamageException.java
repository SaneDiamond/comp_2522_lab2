package ca.bcit2522.Lab2.BAM;

public class DamageException extends RuntimeException {

    public DamageException(final int damage) {
        super("Negative damage is invalid. Damage: " + damage);
    }

}
