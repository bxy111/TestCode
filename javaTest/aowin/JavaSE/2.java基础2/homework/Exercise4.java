import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
//        编写程序，实现如下功能：
//        随机分配一个1～100之间的整数(Math.random()返	回一个double类的数);
//        用户从键盘上输入自己的猜测
//        程序返回提示信息，提示信息分别是“猜大了”、	“猜小了”和“猜对了”。
//        用户可根据提示信息再次输入猜测，直到提示信息	是“猜对了”。

        int randomNum = (int)(Math.random()*100) + 1;
        System.out.println("随机数:" + randomNum);

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入您的猜测:");
            int num = sc.nextInt();
            if (num == randomNum){
                System.out.println("恭喜，您猜对了。");
                break;
            }else if (num < randomNum){
                System.out.println("猜小了。");
            }else{
                System.out.println("猜大了。");
            }
        }
    }
}
