package ca.bcit2522.Lab2.BAM;

/**
 * Main class used to test superclass Creature and its subclasses: CreatureHealer,
 * Date, Dragon, Elf, and Orc.
 *
 * @author Ben, Andre, Marcus
 * @version 1.0
 */
public class Main {

    private static final int HEAL_AMOUNT = 5;

    /**
     * Program's main entry point.
     *
     * @param args command line arguments array
     */
    public static void main(String[] args) {

        Date dragonDate = new Date(2010, 10, 10);
        Creature dragon = new Dragon("Smaug", dragonDate, 300, 80);
        System.out.println(dragon.getDetails());
        System.out.println("Class detected using getClass(): " + dragon.getClass().getSimpleName());
        if (dragon instanceof Dragon){
            System.out.println("This is a dragon, checked using instanceof");
        } else {
            System.out.println("This is not a dragon.");
        }

        Date elfDate = new Date(2008, 8, 8);
        Creature elf = new Elf("Legolas", elfDate, 100, 50);
        System.out.println(elf.getDetails());
        System.out.println("Class detected using getClass(): " + elf.getClass().getSimpleName());
        if (elf instanceof Elf) {
            System.out.println("This is an elf, checked using instanceof");
        } else {
            System.out.println("This is not an elf.");
        }

        Date orcDate = new Date(2000, 4, 20);
        Creature orc = new Orc("Thrall", orcDate, 120, 5);
        System.out.println(orc.getDetails());
        System.out.println("Class detected using getClass(): " + orc.getClass().getSimpleName());
        if (orc instanceof Orc) {
            System.out.println("This is an orc, checked using instanceof");
        } else {
            System.out.println("This is not an orc.");
        }
        Date healerDate = new Date(2001, 11, 9);
        Creature healer = new CreatureHealer("Mercy", healerDate, 60);
        System.out.println(healer.getDetails());
        System.out.println("Class detected using getClass(): " + healer.getClass().getSimpleName());
        if (healer instanceof CreatureHealer){
            System.out.println("This is a healer, checked using instanceof");
        }else {
            System.out.println("This is not a healer.");
        }


        Dragon dragonSmaug;
        Orc orcThrall;
        Elf elfLegolas;
        CreatureHealer healerMercy;

        dragonSmaug = null;
        orcThrall = null;
        elfLegolas = null;
        healerMercy = null;

        if (dragon instanceof Dragon) {
            dragonSmaug = (Dragon) dragon;
        } else {
            System.out.println("This is not a dragon.");
        }

        if (orc instanceof Orc) {
            orcThrall = (Orc) orc;
        } else {
            System.out.println("This is not an orc.");
        }

        if (elf instanceof Elf){
            elfLegolas =  (Elf) elf;
        } else {
            System.out.println("This is not an elf.");
        }

        if (healer instanceof CreatureHealer){
            healerMercy = (CreatureHealer) healer;
        } else {
            System.out.println("This is not a healer.");
        }

        System.out.println(elfLegolas.getName() + " attacks " + orcThrall.getName() + "!");
        try {
            elfLegolas.castSpell(orcThrall);
            System.out.println(orcThrall.getName() + "'s health is now " + orcThrall.getHealthPoints());
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n" + orcThrall.getName() + " attacks " + elfLegolas.getName() + "!");
        try {
            orcThrall.berserk(elfLegolas);
            System.out.println(elfLegolas.getName() + "'s health is now " + elfLegolas.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            orcThrall.heal(HEAL_AMOUNT);
            System.out.println(orcThrall.getName() + " heals himself");
            System.out.println("The amount healed is " + HEAL_AMOUNT);
        } catch (HealingException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(dragonSmaug.getName() + " attacks " + orcThrall.getName() + "!");
        try {
            dragonSmaug.breatheFire(orcThrall);
            System.out.println(dragonSmaug.getName() + "'s health is now " + orcThrall.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println(dragonSmaug.getName() + " attacks " + elfLegolas.getName() + "!");
        try {
            dragonSmaug.breatheFire(elfLegolas);
            System.out.println(elfLegolas.getName() + "'s health is now " + elfLegolas.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(orcThrall.getName() + " attacks " + dragonSmaug.getName() + "1!");
        try {
            orcThrall.berserk(dragonSmaug);
            System.out.println(dragonSmaug.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(orcThrall.getName() + " attacks " + dragonSmaug.getName() + "!");
        try {
            orcThrall.berserk(dragonSmaug);
            System.out.println(dragonSmaug.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(elfLegolas.getName() + " attacks " + dragonSmaug.getName() + "!");
        try {
            elfLegolas.castSpell(dragonSmaug);
            System.out.println(dragonSmaug.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            dragonSmaug.heal(HEAL_AMOUNT);
            System.out.println(dragonSmaug.getName() + " heals himself");
            System.out.println("The amount healed is " + HEAL_AMOUNT);
            System.out.println(dragonSmaug.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (HealingException e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println(elfLegolas.getName() + " attacks " + dragonSmaug.getName() + "!");
        try {
            elfLegolas.castSpell(dragonSmaug);
            System.out.println(elfLegolas.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (LowManaException e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println(dragonSmaug.getName() + " attacks " + orcThrall.getName() + "!");
        try {
            dragonSmaug.breatheFire(orcThrall);
            System.out.println(orcThrall.getName() + "'s health is now " + orcThrall.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println(dragonSmaug.getName() + " attacks " + elfLegolas.getName() + "!");
        try {
            dragonSmaug.breatheFire(elfLegolas);
            System.out.println(elfLegolas.getName() + "'s health is now " + elfLegolas.getHealthPoints());
        } catch (LowFirePowerException e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println(healerMercy.getName() + " heals " + dragonSmaug.getName() + "!");
        try
        {
            healerMercy.healCreature(dragonSmaug);
            System.out.println(dragonSmaug.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (HealingException e)
        {
            System.out.println(e.getMessage());
        }


        System.out.println();
        System.out.println(healerMercy.getName() + " heals " + dragonSmaug.getName() + "!");
        try
        {
            healerMercy.healCreature(dragonSmaug);
            System.out.println(dragonSmaug.getName() + "'s health is now " + dragonSmaug.getHealthPoints());
        } catch (HealingException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(orcThrall.getName() + " attacks " + healerMercy.getName() + "!");
        try {
            orcThrall.berserk(healerMercy);
            System.out.println(healerMercy.getName() + "'s health is now " + healerMercy.getHealthPoints());
        } catch (LowRageException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\nTheir final health is" + "\n" + orcThrall.getName() + ": " + orcThrall.getHealthPoints()
                + "\n" + dragonSmaug.getName() + ": " + dragonSmaug.getHealthPoints()
                + "\n" + elfLegolas.getName() + ": " + elfLegolas.getHealthPoints()
                + "\n" + healerMercy.getName() + ": " + healerMercy.getHealthPoints());
    }
}