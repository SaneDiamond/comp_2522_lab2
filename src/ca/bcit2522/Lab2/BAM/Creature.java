package ca.bcit2522.Lab2.BAM;


public class Creature {

    private static final int MIN_HP = 0;
    private static final int MIN_DMG = 0;
    private static final int MAX_HEALING = 100;
    private static final int MIN_HEAL = 0;

    private final String name;
    private final Date dateOfBirth;
    private int healthPoints;

    public Creature(final String name,
                    final Date dateOfBirth,
                    final int healthPoints) {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealthPoints(healthPoints);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.healthPoints = healthPoints;

    }

    public boolean isAlive() {
        final boolean creatureIsAlive;
        creatureIsAlive = healthPoints > MIN_HP;
        return creatureIsAlive;
    }

    public void takeDamage(final int damage) {
        if (damage >= MIN_DMG) {
            healthPoints -= damage;
            if (healthPoints < MIN_HP) {
                healthPoints = MIN_HP;
            }
        } else {
            throw new DamageException("Negative damage is invalid. Damage: " + damage);
        }
    }

    public void heal(final int healAmount) {
        if (healAmount >= MIN_HEAL) {
            int healingPts = healAmount;

            if (healingPts > MAX_HEALING) {
                healingPts = MAX_HEALING;
            }

            healthPoints += healingPts;
        } else {
            throw new HealingException("Negative healing is invalid. Heal amount: " + healAmount);
        }
    }

    public int getAgeYears() {
        final int ageYears;
        ageYears = Date.subtractYears(Date.CURRENT_DATE, dateOfBirth);
        return ageYears;
    }

    public String getDetails() {
        final StringBuilder detailsBuilder;
        final String details;

        detailsBuilder = new StringBuilder();
        // Processing
        detailsBuilder.append(name);
        detailsBuilder.append("(");
        detailsBuilder.append(dateOfBirth.getYyyyMmDd());
        detailsBuilder.append("), ");
        detailsBuilder.append(getAgeYears());
        detailsBuilder.append(" years old, HP: ");
        detailsBuilder.append(healthPoints);
        details = detailsBuilder.toString();

        return details;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    private static void validateName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null name is invalid.");
        } else if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("A blank or empty name is invalid.");
        }
    }

    private static void validateDateOfBirth(final Date dateOfBirth) {
        // If the difference in years of the dateOfBirth and the current date is
        // negative, than the dateOfBirth is after the current date not possible.
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("A null birth date is not accepted.");
        } else {
            final int yearDifference;
            yearDifference = Date.subtractYears(Date.CURRENT_DATE, dateOfBirth);
            if (yearDifference < 0) {
                throw new IllegalArgumentException("Birth date is in the future (not allowed).");
            }
        }
    }

    private static void validateHealthPoints(final int healthPoints) {
        if (healthPoints < MIN_HP) {
            throw new IllegalArgumentException(String.format("Health points is less than the minimum of %d. Health points: %d",
                    MIN_HP, healthPoints));
        }
    }

}
