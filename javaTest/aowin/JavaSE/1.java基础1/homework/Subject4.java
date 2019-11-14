import java.util.Scanner;

public class Subject4 {
    public static void main(String[] args) {
//        4.编写一个程序，输入一个5位数，将输入数分离成单个数字，然后打印出这些数字，个数字间间隔3个*符号。
//        例如：如果用户输入：42933,那么输出是：4***2***9***3***3
        System.out.println("请输入一个5位整数:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] nums = new int[String.valueOf(a).length()];
        int len = nums.length;
        int i = len - 1;

        while (a > 0 && i >=0){
            nums[i] = a%10;
            a /= 10;
            i--;
        }

        for (int j = 0; j < len; j++) {
            System.out.print(nums[j]);
            if (j != len - 1){
                System.out.print("***");
            } else {
                System.out.println();
            }
        }
    }
}
