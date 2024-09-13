package ca.bcit2522.Lab2.BAM;


public class Orc extends Creature {
    private int rage;

    public Orc(String name, Date dateOfBirth, int healthPoints, int rage) {
        super(name, dateOfBirth, healthPoints);
        validateRage(rage);
        this.rage = rage;
    }

    private static final int MIN_RAGE = 5;
    private static final int MAX_RAGE = 20;

    @Override
    public String getDetails() {
        return "hi";
    }

    public void berserk(int rage) {
        rage += MIN_RAGE;
        if (rage >= MAX_RAGE) {
            rage = MAX_RAGE;
            System.out.println("NOW DEALING DOUBLE THE DAMAGE! RAGE IS " + rage);
        } else if (rage < MIN_RAGE) {
            throw new LowRageException("Rage is too low");
        }
    }












    private static void validateRage(final int rage) {
        if (rage < 0) {
            throw new IllegalArgumentException("Rage cannot be negative.");
        }
    }



}
