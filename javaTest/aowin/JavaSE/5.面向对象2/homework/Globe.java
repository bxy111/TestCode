public class Globe {
//    4.设计一个球的类,有属性半径
//            在类中定义两个方法分别用来计算球的体积和表面积
//    体积：4/3Πr的立方  面积：4Πr的平方 Math.pow(10,3)
//    在创建对象时就给属性赋值
//    写一个测试类，测试方法的正确性

    private double radius;

    public Globe(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return 4/3 * Math.PI * Math.pow(radius, 3);
    }

    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        Globe g = new Globe(5.5);
        System.out.println(g.volume());
        System.out.println(g.area());
    }
}
