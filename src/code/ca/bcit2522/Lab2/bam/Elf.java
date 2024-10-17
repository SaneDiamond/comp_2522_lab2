package ca.bcit2522.Lab2.bam;

/**
 * Represents an Elf, a living Creature from Creature class, but extends to add
 * mana and related functionalities (casting spells and restoring mana).
 *
 * @author Ben Nguyen
 * @author Andre Bernard Chang Dizon
 * @author Marcus Vinicius Santos Lages
 *
 * @version 1.0
 */
public class Elf extends Creature {

    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 50;
    private static final int LOW_MANA = 5;
    private static final int SPELL_COST_MP = 5;
    private static final int SPELL_DMG = 10;
    private static final int MIN_RESTORE_MP = 0;
    private int manaPoints;

    /**
     * Constructs an Elf with the specified attributes.
     *
     * @param name         name of the Elf
     * @param dateOfBirth  birthdate of the Elf
     * @param healthPoints health points of the Elf
     * @param manaPoints   mana points of the Elf
     * @throws IllegalArgumentException if the mana points are less than the minimum mana
     */
    public Elf(final String name, final Date dateOfBirth, final int healthPoints, final int manaPoints) {

        super(name, dateOfBirth, healthPoints);

        validateMana(manaPoints);

        if (manaPoints <= MAX_MANA) {

            this.manaPoints = manaPoints;
        } else {

            this.manaPoints = MAX_MANA;
        }
    }

    /**
     * Returns a detailed description of the Elf including its mana points.
     *
     * @return name, dateOfBirth, age, health and mana points of Elf
     */
    @Override
    public String getDetails() {

        final StringBuilder detailsBuilder;
        final String details;
        final String superDetails;

        detailsBuilder = new StringBuilder();
        superDetails = super.getDetails();

        detailsBuilder.append(superDetails)
                .append(", MP: ")
                .append(manaPoints);

        details = detailsBuilder.toString();

        return details;
    }

    /**
     * Casts a spell on a target Creature, reducing the Elf's mana points
     * and inflicting damage on the victim.
     *
     * @param victim target Creature on which to cast the spell
     * @throws LowManaException if the Elf has insufficient mana to cast a spell
     */
    public void castSpell(final Creature victim) throws LowManaException {

        if (manaPoints < LOW_MANA) {

            throw new LowManaException(manaPoints);
        } else {

            manaPoints -= SPELL_COST_MP;

            if (manaPoints < MIN_MANA) {

                manaPoints = MIN_MANA;
            }

            victim.takeDamage(SPELL_DMG);
            System.out.println(SPELL_DMG + " damage dealt by " + getName());
        }
    }

    /**
     * Restores the Elf's mana points by a specified amount.
     * If the resulting mana points exceed the maximum, they are set to the maximum.
     *
     * @param restoringAmount amount of mana to restore
     * @throws IllegalArgumentException if the restoring amount is negative
     */
    public void restoreMana(final int restoringAmount) {

        if (restoringAmount < MIN_RESTORE_MP) {

            throw new IllegalArgumentException("The amount of MP restored cannot be negative. " +
                    "MP restored: " + restoringAmount);
        }

        manaPoints += restoringAmount;

        if(manaPoints >= MAX_MANA) {

            manaPoints = MAX_MANA;
        }
    }

    // Validates the mana points to not be below MIN_MANA
    private static void validateMana(final int manaPoints) {

        if (manaPoints < MIN_MANA) {

            throw new IllegalArgumentException("Negative mana points are invalid. MP: " + manaPoints);
        }
    }

}
