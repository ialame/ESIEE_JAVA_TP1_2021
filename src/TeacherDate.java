import java.util.TimeZone;

//
// Decompiled by Procyon v0.5.36
//

public class TeacherDate
{
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int DECEMBER = 12;
    private static final int START_YEAR = 1753;
    private static final int DAYS_PER_WEEK = 7;
    private static final String[] DAY_NAMES;
    private static final int[] DAYS_PER_MONTH;
    private int year;
    private int month;
    private int day;

    public static int getDaysSinceEpoch() {
        return (int)((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000L / 60L / 60L / 24L);
    }

    public TeacherDate(final int year, final int month, final int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        if (year < 1753) {
            throw new IllegalArgumentException(this + " year too small: " + year);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(this + " month out of range: " + month);
        }
        if (day < 1 || day > this.getDaysInMonth()) {
            throw new IllegalArgumentException(this + " day out of range: " + day);
        }
    }

    public TeacherDate() {
        this(1970, 1, 1);
        for (int daysSinceEpoch = getDaysSinceEpoch(), i = 0; i < daysSinceEpoch; ++i) {
            this.nextDay();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof TeacherDate)) {
            return false;
        }
        final TeacherDate other = (TeacherDate)o;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public String getDayOfWeek() {
        int dayIndex = 1;
        final TeacherDate temp = new TeacherDate(1753, 1, 1);
        while (!temp.equals(this)) {
            temp.nextDay();
            dayIndex = (dayIndex + 1) % 7;
        }
        return TeacherDate.DAY_NAMES[dayIndex];
    }

    public boolean isLeapYear() {
        return this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0);
    }

    public void nextDay() {
        ++this.day;
        if (this.day > this.getDaysInMonth()) {
            ++this.month;
            this.day = 1;
            if (this.month > 12) {
                ++this.year;
                this.month = 1;
            }
        }
    }

    @Override
    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    private int getDaysInMonth() {
        int result = TeacherDate.DAYS_PER_MONTH[this.month];
        if (this.month == 2 && this.isLeapYear()) {
            ++result;
        }
        return result;
    }

    static {
        DAY_NAMES = new String[] {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi","Samedi" };
        DAYS_PER_MONTH = new int[] { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    }
}