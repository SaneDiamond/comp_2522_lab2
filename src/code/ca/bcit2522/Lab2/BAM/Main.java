package ca.bcit2522.Lab2.BAM;

public class Main {
    public static void main(String[] args) {


        Date dragonDate = new Date(2010, 10, 10);
        Creature dragon = new Dragon("Hanoor", dragonDate, 100, 80);
//        System.out.println(dragon.getDetails());

        Date elfDate = new Date(2008, 8, 8);
        Creature elf = new Elf("Pajeet", elfDate, 100, 50);
//        System.out.println(elf.getDetails());
        Date orcDate = new Date(2000, 4, 20);
        Creature orc = new Orc("Thrall", orcDate, 120, 5);

        Orc orcThrall = new Orc("Thrall", orcDate, 120, 5);
        Elf elfPajeet = new Elf("Pajeet", elfDate, 100, 50);
        Dragon dragonHanoor = new Dragon("Hanoor", dragonDate, 100, 80);


        // store creatures in array
        Creature[] creatures = {dragon, elf, orc};
        // loop through creatures and get details of each
        for (Creature creature : creatures)
        {
            {
                System.out.println(creature.getDetails());

                // using instance of to check class
                switch (creature)
                {
                    case Dragon dragon1 -> System.out.println("This is a Dragon, checked with using instanceof");
                    case Elf elf1 -> System.out.println("This is an Elf, checked with using instanceof");
                    case Orc orc1 -> System.out.println("This is an Orc, checked with using instanceof");
                    default ->
                    {
                    }
                }
                // check class using the get class method to also check class
                System.out.println("Class detected using getClass(): " + creature.getClass().getSimpleName() + "\n");
            }


        }
        try {
            elfPajeet.castSpell(orcThrall);
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            orcThrall.berserk(elfPajeet);
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(elfPajeet.getDetails());

        try {
            dragonHanoor.breatheFire(orcThrall);
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(orcThrall.getDetails());

        try {
            orcThrall.berserk(dragonHanoor);
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        try {
            orcThrall.berserk(dragonHanoor);
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        try {
            orcThrall.berserk(dragonHanoor);
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

    }
}