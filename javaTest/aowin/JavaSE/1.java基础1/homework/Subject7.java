import java.util.Scanner;

public class Subject7 {
    public static void main(String[] args) {
//        7.输入一个数，如果是能被2整除，且能被3整除，则输出：i+”能被N整除” （i是输入的数字）。
//        用&&实现。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int a = sc.nextInt();

        if ((a%2 == 0) && (a%3 == 0)){
            System.out.println(a + "能被2和3整除");
        }
    }
}
