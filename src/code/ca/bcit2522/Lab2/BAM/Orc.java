package ca.bcit2522.Lab2.BAM;

/**
 *  Represents Orc, a subclass that extends Creature, adding berserk as a way to deal damage and rage, which doubles
 *  the berserk damage dealt.
 *
 * @author Andre
 * @version 1.0
 */
public class Orc extends Creature
{
    private static final int MIN_RAGE = 5;
    private static final int MAX_RAGE = 30;
    private static final int NO_RAGE = 0;
    private static final int RAGE_DOUBLE_DAMAGE = 20;

    private static final int BERSERK_DAMAGE = 10;
    private static final int BERSERK_DAMAGE_DOUBLED = 20;

    private final int rage;

    // Marcus:
    // - Common organization of a program:
    //   1. Constants
    //   2. Instance variables
    //   3. Constructors
    //   4. Rest of the methods
    //   5. Helper methods

    // Marcus:
    // - Add final to the argument

    /**
     *
     * @param name is the name of the orc.
     * @param dateOfBirth is the birthdate of the orc.
     * @param healthPoints represents the health points of the orc.
     * @param rage represents a buff. When doubled, berserk deals double the damage.
     */
    public Orc(final String name, final Date dateOfBirth, final int healthPoints, final int rage) {
        super(name, dateOfBirth, healthPoints);
        validateRage(rage);
        this.rage = rage;
    }


    // Marcus:
    // - It would be good if you could use StringBuilder
    @Override
    public String getDetails()
    {
        final StringBuilder detailsBuilder;
        final String details;
        final String superDetails;

        detailsBuilder = new StringBuilder();
        superDetails = super.getDetails();

        detailsBuilder.append(superDetails);
        detailsBuilder.append(", Rage: ");
        detailsBuilder.append(rage);
        details = detailsBuilder.toString();

        return details;
    }

    // Marcus:
    // - Besides dealing damage, the logic is wrong, because the max rage is 30
    //   while the ceiling for applying the 2x dmg is 20
    // - Add final to the argument
    public void berserk(int rage, final Creature victim) {
        rage += MIN_RAGE;
        if (rage >= RAGE_DOUBLE_DAMAGE && rage <= MAX_RAGE)
        {
            System.out.println("NOW DEALING DOUBLE THE DAMAGE! RAGE IS " + rage);
        }
        if (rage >= MAX_RAGE)
        {
            rage = MAX_RAGE;
            System.out.println("NOW DEALING DOUBLE THE DAMAGE! RAGE IS " + rage);
        } else if (rage < MIN_RAGE) {
            throw new LowRageException("Rage is too low");
        }
        if (rage >= RAGE_DOUBLE_DAMAGE)
        {
            victim.takeDamage(BERSERK_DAMAGE_DOUBLED);
        }else
        {
            victim.takeDamage (BERSERK_DAMAGE);
        }
    }

    // Marcus:
    // - Magic number
    /**
     *
     * @param rage when at 20, orc deals double damage.
     * @throws IllegalArgumentException if rage is below 5.
     */
    private static void validateRage(final int rage) {
        if (rage < NO_RAGE) {
            throw new IllegalArgumentException("Rage cannot be negative.");
        }
    }


}