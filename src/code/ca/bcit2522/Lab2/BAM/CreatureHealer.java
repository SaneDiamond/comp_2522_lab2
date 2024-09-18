package ca.bcit2522.Lab2.BAM;

import java.util.Random;

/**
 * Represents a healer creature, a subclass that extends Creature,
 * adding the skill of being able to heal other creatures.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class CreatureHealer extends Creature {

    private static final Random randHealNumber;

    // Initialize the static random number generator just once.
    static {
        randHealNumber = new Random();
    }

    /**
     * Constructor used to create a CreatureHealer object based on the informed
     * parameters.
     *
     * @param name         name of the creature
     * @param dateOfBirth  birthdate of the creature
     * @param healthPoints initial health points of the creature
     * @throws IllegalArgumentException if name or dateOfBirth is null,
     *                                  if name is empty,
     *                                  if healthPoints is negative or
     *                                  if dateOfBirth is in the future.
     */
    public CreatureHealer(final String name, final Date dateOfBirth, final int healthPoints) {
        super(name, dateOfBirth, healthPoints);
    }

    /**
     * Heals the specified creature by applying a random healing value within a defined range,
     * with 50% chance of not working
     *
     * @param healedCreature creature to be healed
     */
    public void healCreature(final Creature healedCreature) {
        final int randomRange = 1;
        final int healingNumber;

        // Create a random number from negative MAX_HEAL to positive MAX_HEAL.
        healingNumber = randHealNumber.nextInt(
                Creature.MAX_HEAL - (- Creature.MAX_HEAL) + randomRange);

        // If random healingNumber is negative, then healing doesn't work
        try {
            healedCreature.heal(healingNumber);
        }  catch(HealingException ex) {
            System.out.println("IT DIDN'T WORK! Creature not healed");
        }
    }
}
