import java.util.Scanner;

public class Subject5 {
    public static void main(String[] args) {
//        5.编写一个Java应用程序,用户从键盘输入一个浮点数据,将该浮点数保留两位小数位输出.3.154893.15
        System.out.println("请输入一个浮点数:");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();

        System.out.printf("%.2f", r);
    }
}
