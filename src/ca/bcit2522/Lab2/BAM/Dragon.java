package ca.bcit2522.Lab2.BAM;

import java.util.Random;

public class Dragon extends Creature {
    Random rand = new Random();

    private static final int EMPTY = 0;
    private static final int MAX_FIRE_POWER = 100;
    private static final int MIN_FIRE_POWER = 10;
    private static final int INVALID_AMOUNT = -100;

    private final String name;
    private final int health;
    private final Date dateOfBirth;
    private int firePower = rand.nextInt(100);


    private static void DragonValidation(String name, Date dateOfBirth, int health, int firePower){
        if (name == null ||
                name.isEmpty() ||
                dateOfBirth == null ||
                health <= EMPTY ||
                firePower < EMPTY ||
                firePower > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("invalid input");
        }

    }    //Constructor with validation
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



    @Override
    public String getDetails() {
        String str = String.format("Name:" + name + "Date Of Birth:" +
                dateOfBirth + "Health:" + health + "FirePower:" + firePower);

        return str;
    }

    public void breatheFire(){
        if (firePower < MIN_FIRE_POWER) {
            try
            {
                restoreFirePower(INVALID_AMOUNT);
            }
            catch (Exception e){
                System.out.println("invalid fire power amount");
            }
            {
            firePower -= MIN_FIRE_POWER;
            System.out.println("20 DAMAGE DEALT");
        }
    }}

    public void restoreFirePower(int amount) {
        if (amount < EMPTY || amount > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Restored amount is invalid");
        }
        Random rand = new Random();
        firePower = rand.nextInt(amount);
        System.out.println("Restored fire power to " + firePower);
    }

}


