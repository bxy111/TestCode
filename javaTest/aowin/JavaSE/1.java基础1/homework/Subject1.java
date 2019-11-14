import java.util.Scanner;

public class Subject1 {
//    1.从屏幕上输入两个整数，交换这两个数并输出
    public static void main(String[] args) {
        System.out.println("请输入两个整数:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + " " + b);
    }
}
