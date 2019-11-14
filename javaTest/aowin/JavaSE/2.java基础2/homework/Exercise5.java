import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
//        5.定义一个double数组并给数组元素赋值，查询输出这个double数组中的最小值
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组大小:");
        int len  = sc.nextInt();
        double[] arr = new double[len];
        System.out.println("请输入数组内容（double类型的数组）:");
        int i = 0;
        while (i < len){
            double d = sc.nextDouble();
            arr[i] = d;
            i++;
        }

        double min = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (min > arr[j]){
                min = arr[j];
            }
        }
        System.out.println("最小值为:"+min);
    }
}
