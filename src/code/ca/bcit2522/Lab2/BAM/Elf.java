package ca.bcit2522.Lab2.BAM;

public class Elf extends Creature {
    private static final int MIN_MP = 0;
    private static final int LOW_MANA = 0;
    private int manaPoints;

    public Elf(String name, Date dateOfBirth, int healthPoints, int manaPoints) {
        super(name, dateOfBirth, healthPoints);

        validateMana(manaPoints);
        this.manaPoints = manaPoints;
    }

    @Override
    public String getDetails() {
        final StringBuilder detailsBuilder;
        final String details;
        final String superDetails;

        detailsBuilder = new StringBuilder();
        superDetails = super.getDetails();

        detailsBuilder.append(superDetails);
        detailsBuilder.append(", MP: ");
        detailsBuilder.append(manaPoints);
        details = detailsBuilder.toString();

        return details;
    }

    private static void validateMana(final int manaPoints) {
        if(manaPoints <= MIN_MP) {

        } else if(manaPoints <= LOW_MANA) {

        }
    }

}
