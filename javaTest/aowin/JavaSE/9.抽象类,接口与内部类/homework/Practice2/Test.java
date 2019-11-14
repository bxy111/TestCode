package Practice2;

public class Test {
    public static void main(String[] args) {
        MyCircle mc = new MyCircle(5);
        MyRectangle mr = new MyRectangle(3, 4);

        System.out.println(mc.calculateArea());
        System.out.println(mr.calculateArea());
    }
}
