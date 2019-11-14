import java.util.Scanner;

public class Subject2 {
    public static void main(String[] args) {
//        2.用户从屏幕上输入圆的半径，然后打印出该圆的直径、周长和面积
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入圆的半径:");
        double r = sc.nextDouble();
        double d = r * 2;
        double pm = Math.PI * d;
        double area = Math.PI * r * r;

        System.out.println("直径:" + d);
        System.out.println("周长:" + pm);
        System.out.println("面积:" + area);
    }
}
