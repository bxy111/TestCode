package Practice3;

public class Test {
    public static void main(String[] args) {
        Triangle ta = new Triangle(3, 4, 5);
        Rectangle ra = new Rectangle(5, 6);

        System.out.println(ta.perimeter());
        System.out.println(ta.area());

        System.out.println(ra.perimeter());
        System.out.println(ra.area());
    }


}
