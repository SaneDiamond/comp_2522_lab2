public class Creature {

    private static int INITIAL_HP = 0;
    private static int MIN_DMG = 0;
    private static int MAX_HEALING = 100;
    private static int MIN_HEAL = 0;

    private String name;
    private Date dateOfBirth;
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
        creatureIsAlive = healthPoints > INITIAL_HP;
        return creatureIsAlive;
    }

    public void takeDamage(final int damage) {
        if (damage >= MIN_DMG) {
            healthPoints -= damage;
            if (healthPoints < INITIAL_HP) {
                healthPoints = INITIAL_HP;
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
        final Date resultDate;
        final int ageYears;

        resultDate = Date.subtractYears(Date.currentDate, dateOfBirth);
        ageYears = resultDate.getYear();

        return ageYears;
    }

    public String getDetails() {
        final StringBuilder detailsBuilder;
        final String details;

        detailsBuilder = new StringBuilder();

        // Processing
        details = detailsBuilder.toString();

        return details;
    }

    private static void validateName(final String name) {

    }

    private static void validateDateOfBirth(final Date dateOfBirth) {
    }

    private static void validateHealthPoints(final int healthPoints) {
    }

}
