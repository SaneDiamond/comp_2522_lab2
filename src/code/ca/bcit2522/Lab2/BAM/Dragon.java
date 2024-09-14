package ca.bcit2522.Lab2.BAM;

import java.util.Random;

// Marcus:
// - Check curly braces and format all over
public class Dragon extends Creature {
    // Marcus:
    // - Common organization of a program:
    //   1. Constants
    //   2. Instance variables
    //   3. Constructors
    //   4. Rest of the methods
    //   5. Helper methods

    // Marcus:
    // - Calling a method outside a method/constructor is very bad practice.// oopsie woopsie
    //   Create rand here, then instantiate it in a constructor or instance initializer.
    // - You should prob give a better name to rand as well, like randNumGenerator or
    //   something like that

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

    // Marcus:
    // - Don't forget to put arguments as final // yes mastah
    // - Names of methods should start with lowercase (example: methodName()) // ok mastah

    private static void dragonValidation(final String name, final Date dateOfBirth, final int health, final int firePower) {
        // Marcus:
        // - Name, health and date of birth are already validated in creature
        // - It's only necessary to validate fire power (don't forget to print why the
        //   error happened and print the value of firePower) // okie dokie master
        if (firePower < EMPTY || firePower > MAX_FIRE_POWER) {
            // Print error message and firePower value
            System.out.println("Invalid firePower: " + firePower);
            throw new IllegalArgumentException("Fire power is out of bounds: " + firePower);
        }
    }


    // Marcus: missing final for arguments // check
    // Constructor with validation
    public Dragon(final String name, final Date dateOfBirth,final int health, final int firePower){
        super(name, dateOfBirth, health);
        // Validation
        dragonValidation(name, dateOfBirth, health, firePower);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
        this.firePower = firePower;
        this.randNumGenerator = new Random();

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
    // - If you can, you can use StringBuilder // okie dokie
    @Override
    public String getDetails() {
        StringBuilder str = new StringBuilder();
        str.append("Name:").append(name)
                .append(" Date Of Birth:").append(dateOfBirth)
                .append(" Health:").append(health)
                .append(" FirePower:").append(firePower);

        return str.toString();
    }

    // Marcus:
    // - In this method, if firePower is less than the minimum it should throw
    //   an error, not try to restore fire power. Then you add "throws" and the
    //   name of the exception to the function name // check prolly
    // - Add damage to a creature through argument (you know it, but just so no
    //   one forgets it // check
    public void breatheFire(Creature creature) throws LowFirePowerException {
        if (firePower < MIN_FIRE_POWER) {
            // Throwing the custom LowFirePowerException
            throw new LowFirePowerException("Fire power is too low to breathe fire.");
        } else {
            // Reducing firePower and applying damage
            firePower -= MIN_FIRE_POWER;
            int damage = 20;
            creature.takeDamage(damage);
            System.out.println(damage + " DAMAGE DEALT");
        }
    }



    // Marcus: missing final for argument // yes mastah
    public void restoreFirePower(final int amount) {
        if (amount < EMPTY || amount > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Restored amount is invalid");
        }
        // Marcus: You already have a random object, you don't need this. // ok sir mb
        Random rand = new Random();
        firePower = randNumGenerator.nextInt(amount);
        System.out.println("Restored fire power to " + firePower);
    }

}
