package ca.bcit2522.Lab2.BAM;

public class Elf extends Creature {
    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 50;
    private static final int LOW_MANA = 5;
    private static final int SPELL_COST_MP = 5;
    private static final int SPELL_DMG = 10;
    private static final int MIN_RESTORE_MP = 0;
    private int manaPoints;

    public Elf(String name, Date dateOfBirth, int healthPoints, int manaPoints) {
        super(name, dateOfBirth, healthPoints);

        validateMana(manaPoints);
        if (manaPoints <= MAX_MANA) {
            this.manaPoints = manaPoints;
        } else {
            this.manaPoints = MAX_MANA;
        }
    }

    @Override
    public String getDetails() {
        final StringBuilder detailsBuilder;
        final String details;
        final String superDetails;

        detailsBuilder = new StringBuilder();
        superDetails = super.getDetails();

        detailsBuilder.append(superDetails);
        detailsBuilder.append(", MP: ");
        detailsBuilder.append(manaPoints);
        details = detailsBuilder.toString();

        return details;
    }

    public void castSpell(final Creature victim) throws LowManaException {
        if (manaPoints < LOW_MANA) {
            throw new LowManaException(manaPoints);
        } else {
            manaPoints -= SPELL_COST_MP;

            if (manaPoints < MIN_MANA) {
                manaPoints = MIN_MANA;
            }

            victim.takeDamage(SPELL_DMG);
        }
    }

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

    private static void validateMana(final int manaPoints) {
        if (manaPoints <= MIN_MANA) {
            throw new IllegalArgumentException("Negative mana points are invalid. MP: " + manaPoints);
        }
    }

}
