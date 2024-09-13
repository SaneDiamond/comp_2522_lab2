package ca.bcit2522.Lab2.BAM;

public class LowRageException extends RuntimeException {
    public LowRageException(final String rageIsTooLow) {
        super(rageIsTooLow);
    }
}
