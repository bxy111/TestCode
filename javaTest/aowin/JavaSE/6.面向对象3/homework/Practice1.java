import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串:");

        String src = sc.nextLine();
        String[] sArr = src.trim().split(" ");
        for (int i = sArr.length - 1; i >= 0; i--) {
            System.out.print(sArr[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
        System.out.println();

        char[] chars = src.trim().toCharArray();
        for (int i = chars.length - 1; i >= 0 ; i--) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
