package ca.bcit2522.Lab2.BAM;

public class Main {
    public static void main(String[] args) {
        // Marcus:
        // - Don't forget to delete debug comments
        Date dragonDate = new Date(2010, 10, 10);
        Creature dragon = new Dragon("Hanoor", dragonDate, 300, 80);
//        System.out.println(dragon.getDetails());

        Date elfDate = new Date(2008, 8, 8);
        Creature elf = new Elf("Pajeet", elfDate, 100, 50);
//        System.out.println(elf.getDetails());
        Date orcDate = new Date(2000, 4, 20);
        Creature orc = new Orc("Thrall", orcDate, 120, 5);

        Orc orcThrall = new Orc("Thrall", orcDate, 120, 5);
        Elf elfPajeet = new Elf("Pajeet", elfDate, 100, 50);
        Dragon dragonHanoor = new Dragon("Hanoor", dragonDate, 100, 80);


        // Marcus:
        // - Jason said no arrays
        //   (I know, it's dumb, but I don't wanna get punched by a bald guy)
        // store creatures in array
        Creature[] creatures = {dragon, elf, orc};
        // loop through creatures and get details of each
        for (Creature creature : creatures) {
            // Marcus:
            // - 2 curly braces unnecessary
            {
                System.out.println(creature.getDetails());

                // Using instance loop of to check class
                switch (creature) {
                    // Marcus:
                    // - Don't use those quick switch cases
                    case Dragon dragon1 -> System.out.println("This is a Dragon, checked with using instanceof");
                    case Elf elf1 -> System.out.println("This is an Elf, checked with using instanceof");
                    case Orc orc1 -> System.out.println("This is an Orc, checked with using instanceof");
                    default -> {
                    }
                }
                // Check class using the get class method to also check class
                System.out.println("Class detected using getClass(): " + creature.getClass().getSimpleName() + "\n");
            }


        }

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