import javax.xml.bind.annotation.XmlType;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
//        计算x+y的值（依次输入数字x、运算符号（如+、-、*、/）、运算数字y，由switch控制进行的运算并得到运算结果）
        System.out.println("请输入表达式（eg: 5 + 3）:");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String a = sc.next();
        int y = sc.nextInt();

        switch (a){
            case "+":{
                System.out.println(x+y);
                break;
            }
            case "-":{
                System.out.println(x-y);
                break;
            }
            case "*":{
                System.out.println(x*y);
                break;
            }
            case "/":{
                if (0 != y){
                    System.out.println(x/y);
                }else{
                    System.out.println("输入错误，除数不能为0！");
                }
                break;
            }
            default:{
                System.out.println("运算符只能为 + - * /");
            }
        }
    }
}
