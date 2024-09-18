package ca.bcit2522.Lab2.BAM;

import java.util.Random;
/**
 * Represents a Dragon, a living Creature from Creature class, but extends to add
 * firepower and related functionalities.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class Dragon extends Creature {

    private static final int EMPTY = 0;
    private static final int MAX_FIRE_POWER = 100;
    private static final int MIN_FIRE_POWER = 10;
    private static final int INVALID_AMOUNT = -100;
    private static final int FIRE_POWER_DMG = 20;

    private final String name;
    private final int health;
    private final Date dateOfBirth;
    // Marcus:
    // - Calling a method outside of a method/constructor is very bad practice.
    //   Create rand here, then instantiate it in a constructor or instance initializer.
    Random randNumGenerator = new Random();
    private int firePower = randNumGenerator.nextInt(100);

    /**
     * Constructs a Dragon with the specified attributes.
     *
     * @param name name of the dragon
     * @param dateOfBirth date of birth of the dragon
     * @param health health of the dragon
     * @param firePower firepower of the dragon
     */
    public Dragon(final String name, final Date dateOfBirth,final int health, final int firePower){
        super(name, dateOfBirth, health);
        dragonValidation(firePower);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
        this.firePower = firePower;
        this.randNumGenerator = new Random();

    }

    /**
     * Validates the firepower of the dragon in case the firepower is out
     * of bounds. A exception would then be thrown.
     *
     * @param firePower fire power of the dragon
     */
    private static void dragonValidation(final int firePower) {
        if (firePower < EMPTY || firePower > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Fire power is out of bounds: " + firePower);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getFirePower() {
        return firePower;
    }

    /**
     * Returns a string of the dragons details.
     *
     * @return str a concatenated version of the details of the dragon
     */
    @Override
    public String getDetails() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(name)
                .append("\nDate Of Birth: ").append(dateOfBirth.getYyyyMmDd()) //holay molay i spent 30 minutes looking for this error
                .append("\nHealth: ").append(health)
                .append("\nFirePower: ").append(firePower);

        return str.toString();
    }

    /**
     * A move from the dragon attacking another creature.
     *
     * @param creature the name of the victim
     * @throws LowFirePowerException an exception thrown when firepower cost is higher than current firepower
     */
    public void breatheFire(final Creature creature) throws LowFirePowerException {
        if (firePower < MIN_FIRE_POWER) {
            // Throwing the custom LowFirePowerException
            throw new LowFirePowerException("Fire power is too low to breathe fire.");
        } else {
            // Reducing firePower and applying damage
            firePower -= MIN_FIRE_POWER;
            // Marcus: magic number
            creature.takeDamage(FIRE_POWER_DMG);
            System.out.println(FIRE_POWER_DMG + " damage dealt by " + getName());
        }
    }

    /**
     * a method to restore the firepower of the dragon, in case the dragon does
     * not have enough firepower.
     *
     * @param amount the amount of firepower to be restored to the dragon.
     */
    public void restoreFirePower(final int amount) {
        if (amount < EMPTY || amount > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Restored amount is invalid");
        }
        firePower = randNumGenerator.nextInt(amount);
        System.out.println("Restored fire power to " + firePower);
    }

}
