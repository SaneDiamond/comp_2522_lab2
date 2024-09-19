package ca.bcit2522.Lab2.BAM;

/**
 * Class that represents a living creature with name, birthdate and
 * health points.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class Creature {
    // Constants for floor/ceiling of hp, dmg and heal
    private static final int MIN_HP = 0;
    private static final int MIN_DMG = 0;
    private static final int MIN_YEAR_DIFF = 0;
    /**
     * Represents the minimum amount of healing.
     */
    public static final int MIN_HEAL = 0;

    /**
     * Represents the maximum amount of healing.
     */
    public static final int MAX_HEAL = 100;

    private final String name;
    private final Date dateOfBirth;
    private int healthPoints;

    /**
     * Constructor used to create a Creature object based on the informed
     * parameters.
     *
     * @param name          name of the creature
     * @param dateOfBirth   birthdate of the creature
     * @param healthPoints  initial health points of the creature
     * @throws IllegalArgumentException if name or dateOfBirth is null,
     *                                  if name is empty,
     *                                  if healthPoints is negative or
     *                                  if dateOfBirth is in the future.
     */
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

    /**
     * Checks if the creature alive, i.e. with HP above 0.
     *
     * @return true if creature is alive (HP > 0)
     */
    public boolean isAlive() {
        final boolean creatureIsAlive;
        creatureIsAlive = healthPoints > MIN_HP;
        return creatureIsAlive;
    }

    /**
     * Deals damage to the creature based on input amount.
     *
     * @param damage amount of damage being dealt to the creature
     * @throws DamageException if damage is negative
     */
    public void takeDamage(final int damage) {
        if (damage >= MIN_DMG) {
            healthPoints -= damage;

            // Caps healthPoints to MIN_HP
            if (healthPoints < MIN_HP) {
                healthPoints = MIN_HP;
            }
        } else {
            throw new DamageException(damage);
        }
    }

    /**
     * Heals the creature based on input amount.
     *
     * @param healAmount amount of health points the creature will recover
     * @throws HealingException if healAmount is negative
     */
    public void heal(final int healAmount) {
        if (healAmount >= MIN_HEAL) {
            int healingPts;
            healingPts = healAmount;

            // Caps healing to MAX_HEALING
            if (healingPts > MAX_HEAL) {
                healingPts = MAX_HEAL;
            }

            healthPoints += healingPts;
        } else {
            throw new HealingException(healAmount);
        }
    }

    /**
     * Calculates how old is the creature based on Date.CURRENT_DATE in years.
     *
     * @return how many years old is the creature
     */
    public int getAgeYears() {
        final int ageYears;
        ageYears = Date.subtractYears(Date.CURRENT_DATE, dateOfBirth);
        return ageYears;
    }

    /**
     * Retrieves the details of the creature as a String.
     *
     * @return name, dateOfBirth, age and health points of creature
     */
    public String getDetails() {
        final StringBuilder detailsBuilder;
        final String details;

        detailsBuilder = new StringBuilder();
        detailsBuilder.append(name)
                .append("(")
                .append(dateOfBirth.getYyyyMmDd())
                .append("), ")
                .append(getAgeYears())
                .append(" years old, HP: ")
                .append(healthPoints);

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

    // Used to validate name so it's not null, blank or empty.
    private static void validateName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null name is invalid.");
        } else if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("A blank or empty name is invalid.");
        }
    }

    // Used to validate dateOfBirth so it's not null or in the future.
    private static void validateDateOfBirth(final Date dateOfBirth) {
        // If the difference in years of the dateOfBirth and the current date is
        // negative, then the dateOfBirth is after the current date not possible.
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("A null birth date is not accepted.");
        } else {
            final int yearDifference;
            yearDifference = Date.subtractYears(Date.CURRENT_DATE, dateOfBirth);
            if (yearDifference < MIN_YEAR_DIFF) {
                throw new IllegalArgumentException("Birth date is in the future (not allowed).");
            }
        }
    }

    // Used to validate healthPoints so it's below MIN_HP.
    private static void validateHealthPoints(final int healthPoints) {
        if (healthPoints < MIN_HP) {
            throw new IllegalArgumentException(String.format("Health points is less than the minimum of %d. Health points: %d",
                    MIN_HP, healthPoints));
        }
    }

}
