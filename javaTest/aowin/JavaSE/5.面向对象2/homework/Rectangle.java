public class Rectangle {
//    3. 编写一个名为 Rectangle 的类表示矩形
//    有两个双精度浮点型私有属性：width、height
//    一个默认长和宽都为1的构造方法，一个指定长和宽的构造方法 公有的求面积和周长的方法
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 7);

        System.out.println(r.area());
        System.out.println(r.perimeter());
    }
}
