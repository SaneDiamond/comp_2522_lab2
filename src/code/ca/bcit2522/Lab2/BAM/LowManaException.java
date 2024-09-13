package ca.bcit2522.Lab2.BAM;

public class LowManaException extends Exception {
    public LowManaException(final int manaPoints) {
        super("You don't have enough mana to cast a spell. MP: " + manaPoints);
    }
}
