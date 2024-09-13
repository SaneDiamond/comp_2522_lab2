package ca.bcit2522.Lab2.BAM;

public class HealingException extends RuntimeException {

    public HealingException(final int healingAmount) {
        super("Negative healing is invalid. Heal amount: " + healingAmount);
    }

}
