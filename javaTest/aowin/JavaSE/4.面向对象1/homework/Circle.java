//3. 定义一个圆的类，有属性表示圆的半径，包含两个求圆的周长、面积的方法

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
//    周长
    public double perimeter() {
        return Math.PI * this.radius *2;
    }

//    面积
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public static void main(String[] args) {
        Circle c = new Circle(5.5);
        System.out.println(c.perimeter());
        System.out.println(c.area());
    }
}
