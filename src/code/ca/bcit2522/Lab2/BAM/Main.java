package ca.bcit2522.Lab2.BAM;

/**
 * Main class used to test superclass Creature and its subclasses: CreatureHealer,
 * Date, Dragon, Elf, and Orc.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class Main {

    /**
     * Program's main entry point.
     *
     * @param args command line arguments array
     */
    public static void main(String[] args) {
        // Marcus:
        // - Don't forget to delete debug comments
        Date dragonDate = new Date(2010, 10, 10);
        Creature dragon = new Dragon("Smaug", dragonDate, 300, 80);
        System.out.println(dragon.getDetails());
        System.out.println("Class detected using getClass(): " + dragon.getClass().getSimpleName());

        // Marcus: Avoid ternary operators
        System.out.println(dragon instanceof Creature ? "This is a Dragon, checked using instanceof\n" : "This is not a Dragon");

        Date elfDate = new Date(2008, 8, 8);
        Creature elf = new Elf("Legolas", elfDate, 100, 50);
        System.out.println(elf.getDetails());
        System.out.println("Class detected using getClass(): " + elf.getClass().getSimpleName());
        System.out.println(elf instanceof Creature ? "This is an elf, checked using instanceof\n" : "This is not a Dragon");

        Date orcDate = new Date(2000, 4, 20);
        Creature orc = new Orc("Thrall", orcDate, 120, 5);
        System.out.println(orc.getDetails());
        System.out.println("Class detected using getClass(): " + orc.getClass().getSimpleName());
        System.out.println(orc instanceof Creature ? "This is a orc, checked using instanceof\n" : "This is not a Dragon");


        Dragon dragonHanoor = new Dragon("Smaug", dragonDate, 100, 80);
        Orc orcThrall = new Orc("Thrall", orcDate, 120, 5);
        Elf elfPajeet = new Elf("Legolas", elfDate, 100, 50);


        // Marcus:
        // - Jason said no arrays
        //   (I know, it's dumb, but I don't wanna get punched by a bald guy)
        // bruh what da hell bruh
        // store creatures in array
//        Creature[] creatures = {dragon, elf, orc};
//        // loop through creatures and get details of each
//        for (Creature creature : creatures) {
//            // Marcus:
//            // - 2 curly braces unnecessary // oki doki
//                // Using instance loop of to check class
//                switch (creature) {
//                    // Marcus:
//                    // - Don't use those quick switch cases
//                    case Dragon dragon1 -> System.out.println("This is a Dragon, checked with using instanceof");
//                    case Elf elf1 -> System.out.println("This is an Elf, checked with using instanceof");
//                    case Orc orc1 -> System.out.println("This is an Orc, checked with using instanceof");
//                    default -> {
//                    }
//                }
//        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("Pajeet attacks Thrall!");
        try {
            elfPajeet.castSpell(orcThrall);
            System.out.println("Thrall's health is now " + orcThrall.getHealthPoints());
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nThrall attacks Pajeet!");
        try {
            orcThrall.berserk(elfPajeet);
            System.out.println("Pajeet's health is now " + elfPajeet.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nHanoor attacks Thrall!");
        try {
            dragonHanoor.breatheFire(orcThrall);
            System.out.println("Thrall's health is now " + orcThrall.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nHanoor attacks Pajeet!");
        try {
            dragonHanoor.breatheFire(elfPajeet);
            System.out.println("Pajeet's health is now " + elfPajeet.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nThrall attacks Hanoor!");
        try {
            orcThrall.berserk(dragonHanoor);
            System.out.println("Hanoor's health is now " + dragonHanoor.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nThrall attacks Hanoor!");
        try {
            orcThrall.berserk(dragonHanoor);
            System.out.println("Hanoor's health is now " + dragonHanoor.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nPajeet attacks Hanoor!");
        try {
            elfPajeet.castSpell(dragonHanoor);
            System.out.println("Hanoor's health is now " + dragonHanoor.getHealthPoints());
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }
            dragonHanoor.heal(5);
            System.out.println(dragon.getName() + "Heals himself");
        try {
        } catch (HealingException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nPajeet attacks Hanoor!");
        try {
            elfPajeet.castSpell(dragonHanoor);
            System.out.println("Hanoor's health is now " + dragonHanoor.getHealthPoints());
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nHanoor attacks Thrall!");
        try {
            dragonHanoor.breatheFire(orcThrall);
            System.out.println("Thrall's health is now " + orcThrall.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nHanoor attacks Pajeet!");
        try {
            dragonHanoor.breatheFire(elfPajeet);
            System.out.println("Pajeet's health is now " + elfPajeet.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }

        // Marcus:
        // - Use the name of the object instead of just "Pajeet"
        //   example: creature.getName()
        System.out.println("\nTheir final health is" + "\nThrall: " + orcThrall.getHealthPoints() + "\nHanoor: "
                + dragonHanoor.getHealthPoints() + "\nPajeet: " + elfPajeet.getHealthPoints());
    }
}