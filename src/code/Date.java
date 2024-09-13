/**
 * Class that represents a Date with year, month and day.
 *
 * @author Andre, Ben, Marcus, Sam
 * @version 1.0
 */
public class Date {
    // Constants used to check first and last day, month, year.
    private static final int FIRST_YEAR = 1;
    private static final int CURRENT_YEAR = 2024;
    private static final int FIRST_DAY = 1;
    private static final int COMMON_MONTH_LAST_DAY = 30;
    private static final int EXTENDED_MONTH_LAST_DAY = 31;
    private static final int FEBRUARY_LAST_DAY = 28;
    private static final int FEBRUARY_LEAP_YEAR_LAST_DAY = 29;
    private static final int MAX_WEEK_DAYS = 7;

    /**
     * Symbolic constant for getting the current date.
     */
    public static final Date CURRENT_DATE = new Date(2024, 8, 12);

    /*
        Array for getting the written weekday.
        !IMPORTANT: Use DAY_OF_WEEK[ weekdayNumber-1 ] to access the proper day
    */
    private static final String[] DAY_OF_WEEK = {
            "saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"
    };

    // Constants for representing months as numbers.
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    /*
        Array for getting the written month.
        !IMPORTANT: Use MONTH_TEXT[ monthNumber - ARRAY_ACCESS_NUM ] to access the proper day
    */
    private static final String[] MONTH_TEXT = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    private static final int ARRAY_ACCESS_NUM = 1;

    // Array for getting the month code constant for use for calculating the day of the week.
    private static final int[] MONTH_CODES = { 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6 };

    // Attributes for year, month and day of a Date object.
    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructor that creates a new Date object considering
     * the format Y-M-D.
     *
     * @param year  year as int.
     * @param month month as int.
     * @param day   day as int.
     * @throws IllegalArgumentException if the date is valid (is not null, exists and if it's 1AD or after)
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the date in yyyy-mm-dd format.
     *
     * @return date in yyyy-mm-dd format
     */
    public String getYyyyMmDd() {
        final StringBuilder ymdBuffer;
        final String str;

        ymdBuffer = new StringBuilder();

        ymdBuffer.append(year);
        ymdBuffer.append("-");
        ymdBuffer.append(month);
        ymdBuffer.append("-");
        ymdBuffer.append(day);

        str = ymdBuffer.toString();
        return str;

    }

    /**
     * Returns the date in Month dd, yyyy format.
     *
     * @return date in Month dd, yyyy format
     */
    public String getMonthDdYyyy() {
        final StringBuilder mdyBuffer;
        mdyBuffer = new StringBuilder();

        mdyBuffer.append(MONTH_TEXT[month - ARRAY_ACCESS_NUM]);
        mdyBuffer.append(" ");
        mdyBuffer.append(day);
        mdyBuffer.append(", ");
        mdyBuffer.append(year);

        return mdyBuffer.toString();
    }

    /**
     * Returns a String with date in format weekday, Month Dd, Yyyy.
     *
     * @return date in weekday, Month Dd, Yyyy format
     */
    public String getWeekdayDate() {
        final StringBuilder formattedDateBuffer;
        formattedDateBuffer = new StringBuilder();

        formattedDateBuffer.append(getDayOfWeek());
        formattedDateBuffer.append(", ");
        formattedDateBuffer.append(getMonthDdYyyy());

        return formattedDateBuffer.toString();
    }

    /**
     * Returns the day of the week.
     *
     * step 1: calculate the number of twelves in 77: 6
     * step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 = 5
     * step 3: calculate the number of fours in step 2: 5/4 = 1.25, so 1
     * step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 = 43
     * step 5: add the month code (for /jfmamjjasond: 144025036146): for october it is 1: 43 + 1 = 44
     * step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)
     * step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday
     *
     * Extra notes:
     * a) for January/February dates in leap years, add 6 at the start
     * b) for all dates in the 2000s, add 6 at the start
     * c) for all dates in the 1800s, add 2 at the start
     *
     * @return day of the week
     */
    public String getDayOfWeek() {
        final int constStep3 = 4;
        final int monthCodeAccess = 1;
        final boolean leapYear = isLeapYear(year);

        // Constants to get the unit and decimal parts of a year.
        final int centuryYearsConst = 100;
        final int firstDigitsOfYear = year % centuryYearsConst;
        int resultWeekday;

        // Checks the extra conditions and returns initial weekday value
        resultWeekday = getInitialWeekday(month, year, leapYear);

        // Step 1
        final int result1Const;
        result1Const = firstDigitsOfYear / DECEMBER;

        // Step 2
        final int result2Const;
        result2Const = firstDigitsOfYear % DECEMBER;

        // Step 3
        final int result3Const;
        result3Const = result2Const / constStep3;

        // Step 4
        resultWeekday += day + result1Const + result2Const + result3Const;

        // Step 5
        resultWeekday += MONTH_CODES[month - monthCodeAccess];

        // Step 6
        resultWeekday %= MAX_WEEK_DAYS;

        return DAY_OF_WEEK[resultWeekday];
    }

    /**
     * Gets how many whole years from date1 to date2 (truncated/rounded down).
     *
     * @param date1 minuend of Date subtraction
     * @param date2 subtrahend of Date subtraction
     * @return years of difference between date1 and date2
     */
    public static int subtractYears(final Date date1, final Date date2) {
        final int date1Month;
        final int date1Day;
        final int date2Month;
        final int date2Day;
        int result;

        date1Month = date1.getMonth();
        date1Day = date1.getYear();
        date2Month = date2.getMonth();
        date2Day = date2.getYear();
        result = date1.getYear() - date2.getYear();

        if (date1Month >= date2Month &&
                date1Day >= date2Day) {
            result++;
        }

        return result;
    }

    /**
     * Returns the year represented in this Date object.
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month represented in this Date object.
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day represented in this Date object.
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    // Returns the number of days in a month according to the month and if it's a leap year.
    private static int getNumOfDaysInMonth(final int month,
                                           final int year) {
        switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
                return EXTENDED_MONTH_LAST_DAY;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER:
                return COMMON_MONTH_LAST_DAY;
            case FEBRUARY:
                if (isLeapYear(year))
                    return FEBRUARY_LEAP_YEAR_LAST_DAY;
                else
                    return FEBRUARY_LAST_DAY;
            default:
                throw new IllegalArgumentException("Invalid month argument. Month: " + month);
        }
    }

    /*
        Used to check if a year is a leap year.

        1. A year is a leap year if it's divisible by 4 (like 2016),
        unless it's divisible by 100 (like 1900).
        2. If it's divisible by 100, it's again a leap year if it's
        also divisible by 400 (like 2000).
     */
    private static boolean isLeapYear(final int year) {
        final int divisibleConst;
        final int positiveConst;
        final int leapYearConst1;
        final int leapYearConst2;
        final int leapYearConst3;

        divisibleConst = 0;
        positiveConst = 0;
        leapYearConst1 = 4;
        leapYearConst2 = 100;
        leapYearConst3 = 400;

        return (year > positiveConst)
                && (year % leapYearConst1 == divisibleConst && year % leapYearConst2 != divisibleConst
                || year % leapYearConst3 == divisibleConst);
    }

    /*
        Helper function to check the initial extra conditions and returns initial weekday value

        Extra notes:
            a) for January/February dates in leap years, add 6 at the start
            b) for all dates in the 2000s, add 6 at the start
            c) for all dates in the 1800s, add 2 at the start
     */
    private static int getInitialWeekday(final int month,
                                         final int year,
                                         final boolean isLeapYearConst) {
        final int exceptionYear1;
        final int exceptionYear2;
        final int exceptionYear2UpperBound;
        final int correctionConst1;
        final int correctionConst2;
        int resultWeekday;

        exceptionYear1 = 2000;
        exceptionYear2 = 1800;
        exceptionYear2UpperBound = 1900;
        correctionConst1 = 6;
        correctionConst2 = 2;
        resultWeekday = 0;

        // Extra a)
        if (isLeapYearConst && (month == JANUARY || month == FEBRUARY))
            resultWeekday += correctionConst1;

        // Extra b) and c)
        if (year >= exceptionYear1)
            resultWeekday += correctionConst1;
        else if (year >= exceptionYear2 && year < exceptionYear2UpperBound)
            resultWeekday += correctionConst2;

        return resultWeekday;
    }

    // Validates year to be between 1 AD and current year (2024).
    private static void validateYear(final int year) {
        if (year < FIRST_YEAR)
            throw new IllegalArgumentException("Year not valid (before 1AD). Year: " + year);
        else if (year > CURRENT_YEAR)
            throw new IllegalArgumentException("Year not valid (after current year: "
                    + CURRENT_YEAR + "). Year: " + year);
    }

    // Validates month to be between 1 (January) and 12 (December).
    private static void validateMonth(final int month) {
        if (month < JANUARY)
            throw new IllegalArgumentException("Month doesn't accept negative numbers. Month: " + month);
        else if (month > DECEMBER)
            throw new IllegalArgumentException("Month not valid (after last month: "
                    + DECEMBER + "). Month: " + month);
    }

    /*
        Validates year to be between 1 and 28/29/30/31 (depending on the month and if the year
        is a leap year.
     */
    private static void validateDay(final int year,
                                    final int month,
                                    final int day) {
        final int daysInMonth = getNumOfDaysInMonth(month, year);
        if (day < FIRST_DAY)
            throw new IllegalArgumentException("Day doesn't accept negative numbers. Day: " + day);
        else if (day > daysInMonth)
            throw new IllegalArgumentException("Day not valid (after last day of the provided month: "
                    + daysInMonth + "th day. Day: " + day);
    }

}

