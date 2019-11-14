import java.util.Scanner;

public class Subject6 {
    public static void main(String[] args) {
//        6.输入一个数，如果是能被N、N2、N3整除，
//        则输出：　i+“能被N或者N2或者N3整除” （i是输入的数字，N=3,N2=4,N3=5）。用||实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int a = sc.nextInt();

        if ((a%3 == 0) || (a%4 == 0) || (a%5 == 0)){
            System.out.println(a + "能被3或者4或者5整除");
        }
    }
}
