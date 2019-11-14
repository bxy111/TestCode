import java.util.Scanner;

public class Subject3 {
    public static void main(String[] args) {
//        3.编写一个应用程序，读取用户输入的一个整数，判断该整数的奇偶性，并将结果显示在控制台上.
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int a = sc.nextInt();
        System.out.println(a%2==0?"偶数":"奇数");
    }
}
