package ca.bcit2522.Lab2.BAM;

import java.util.Random;

public class CreatureHealer extends Creature {

    private static Random randHealNumber;

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
    public CreatureHealer(String name, Date dateOfBirth, int healthPoints) {
        super(name, dateOfBirth, healthPoints);
    }


    public void healCreature(final Creature healedCreature) {
        final int randomRange = 1;
        final int healingNumber = randHealNumber.nextInt(
                Creature.MAX_HEAL - (-Creature.MAX_HEAL) + randomRange);

        try {
            healedCreature.heal(healingNumber);
        }  catch(HealingException ex) {
            System.out.println("IT DIDN'T WORK! Creature not healed");
        }
    }
}
