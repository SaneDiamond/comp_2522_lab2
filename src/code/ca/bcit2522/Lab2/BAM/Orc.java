package ca.bcit2522.Lab2.BAM;

public class Orc extends Creature {
    private int rage;

    // Marcus:
    // - Common organization of a program:
    //   1. Constants
    //   2. Instance variables
    //   3. Constructors
    //   4. Rest of the methods
    //   5. Helper methods

    // Marcus:
    // - Add final to the argument
    public Orc(String name, Date dateOfBirth, int healthPoints, int rage) {
        super(name, dateOfBirth, healthPoints);
        validateRage(rage);
        this.rage = rage;
    }

    private static final int MIN_RAGE = 5;
    private static final int MAX_RAGE = 20;

    // Marcus:
    // - It would be good if you could use StringBuilder
    @Override
    public String getDetails() {
        return String.format("%s, Rage: %d", super.getDetails(), rage);
    }

    // Marcus:
    // - Besides dealing damage, the logic is wrong, because the max rage is 30
    //   while the ceiling for applying the 2x dmg is 20
    // - Add final to the argument
    public void berserk(int rage) {
        rage += MIN_RAGE;
        if (rage >= MAX_RAGE) {
            rage = MAX_RAGE;
            System.out.println("NOW DEALING DOUBLE THE DAMAGE! RAGE IS " + rage);
        } else if (rage < MIN_RAGE) {
            throw new LowRageException("Rage is too low");
        }
    }

    // Marcus:
    // - Magic number
    private static void validateRage(final int rage) {
        if (rage < 0) {
            throw new IllegalArgumentException("Rage cannot be negative.");
        }
    }


}