package Practice4;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        year = 2000;
        month = 1;
        day = 1;
    }

    public static void main(String[] args) {
        MyDate md = new MyDate();

        System.out.println(md);
        md.set(1990, 12, 3);
        System.out.println(md);
        System.out.println(md.isLeapYear());
    }

    public void set(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public boolean isLeapYear() {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
