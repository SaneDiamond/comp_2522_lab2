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
    // - Calling a method outside of a method/constructor is very bad practice.
    //   Create rand here, then instantiate it in a constructor or instance initializer.
    // - You should prob give a better name to rand as well, like randNumGenerator or
    //   something like that
    Random rand = new Random();

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
    private int firePower = rand.nextInt(100);

    // Marcus:
    // - Don't forget to put arguments as final
    // - Names of methods should start with lowercase (example: methodName())
    private static void DragonValidation(String name, Date dateOfBirth, int health, int firePower){
        // Marcus:
        // - Name, health and date of birth are already validated in creature
        // - It's only necessary to validate fire power (don't forget to print why the
        //   error happened and print the value of firePower)
        if (name == null ||
                name.isEmpty() ||
                dateOfBirth == null ||
                health <= EMPTY ||
                firePower < EMPTY ||
                firePower > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("invalid input");
        }

    }

    // Marcus: missing final for arguments
    //Constructor with validation
    public Dragon(String name, Date dateOfBirth, int health, int firePower){
        super(name, dateOfBirth, health);
        // Validation
        DragonValidation(name, dateOfBirth, health, firePower);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
        this.firePower = firePower;

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
    //   put String str as final
    // - If you can, you can use StringBuilder
    @Override
    public String getDetails() {
        String str = String.format("Name:" + name + "Date Of Birth:" +
                dateOfBirth + "Health:" + health + "FirePower:" + firePower);

        return str;
    }

    // Marcus:
    // - In this method, if firePower is less than the minimum it should throw
    //   an error, not try to restore fire power. Then you add "throws" and the
    //   name of the exception to the function name
    // - Add damage to a creature through argument (you know it, but just so no
    //   one forgets it
    public void breatheFire(){
        if (firePower < MIN_FIRE_POWER) {
            try
            {
                restoreFirePower(INVALID_AMOUNT);
            }
            catch (Exception e){
                System.out.println("invalid fire power amount");
            }
            // Marcus:
            // - This braces are not linked to anything.
            {
                firePower -= MIN_FIRE_POWER;
                System.out.println("20 DAMAGE DEALT");
            }
        }}

    // Marcus: missing final for argument
    public void restoreFirePower(int amount) {
        if (amount < EMPTY || amount > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Restored amount is invalid");
        }
        // Marcus: You already have a random object, you don't need this.
        Random rand = new Random();
        firePower = rand.nextInt(amount);
        System.out.println("Restored fire power to " + firePower);
    }

}
