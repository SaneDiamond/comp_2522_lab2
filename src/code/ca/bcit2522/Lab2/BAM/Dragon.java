package ca.bcit2522.Lab2.BAM;

import java.util.Random;

public class Dragon extends Creature {
    // Marcus:
    // - Common organization of a program:
    //   1. Constants
    //   2. Instance variables
    //   3. Constructors
    //   4. Rest of the methods
    //   5. Helper methods

    private static final int EMPTY = 0;
    private static final int MAX_FIRE_POWER = 100;
    private static final int MIN_FIRE_POWER = 10;
    private static final int INVALID_AMOUNT = -100;

    private final String name;
    private final int health;
    private final Date dateOfBirth;
    // Marcus:
    // - Calling a method outside of a method/constructor is very bad practice.
    //   Create rand here, then instantiate it in a constructor or instance initializer.
    Random randNumGenerator = new Random();
    private int firePower = randNumGenerator.nextInt(100);
    // Marcus: missing final for arguments // check
    // Constructor with validation
    public Dragon(final String name, final Date dateOfBirth,final int health, final int firePower){
        super(name, dateOfBirth, health);
        dragonValidation(firePower);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
        this.firePower = firePower;
        this.randNumGenerator = new Random();

    }
    // Marcus:
    // - Since you are only validating firePower, you don't need to pass down the other arguments //oh true
    //   You can prob change the name of the method to firePowerValidation or something like that then // hee hee maybe
    // - Don't forget to put this method after the constructor. Constructor should always be the
    //   first "method" to appear in your class // oki dokie
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


    // Marcus:
    // - Don't forget to instatiate and initialize in different lines and
    //   put String str as final //check
    //   ex:
    //      Object s;
    //      s = new Object();
    // - Good usage of StringBuilder :)
    @Override
    public String getDetails() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(name)
                .append("\nDate Of Birth: ").append(dateOfBirth.getYyyyMmDd()) //holay molay i spent 30 minutes looking for this error
                .append("\nHealth: ").append(health)
                .append("\nFirePower: ").append(firePower);

        return str.toString();
    }

    // Marcus:
    // - Don't forget to put arguments as final
    public void breatheFire(final Creature creature) throws LowFirePowerException {
        if (firePower < MIN_FIRE_POWER) {
            // Throwing the custom LowFirePowerException
            throw new LowFirePowerException("Fire power is too low to breathe fire.");
        } else {
            // Reducing firePower and applying damage
            firePower -= MIN_FIRE_POWER;
            // Marcus: magic number
            int damage = 20;
            creature.takeDamage(damage);
            System.out.println(damage + " DAMAGE DEALT");
        }
    }

    public void restoreFirePower(final int amount) {
        if (amount < EMPTY || amount > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Restored amount is invalid");
        }
        firePower = randNumGenerator.nextInt(amount);
        System.out.println("Restored fire power to " + firePower);
    }

}
