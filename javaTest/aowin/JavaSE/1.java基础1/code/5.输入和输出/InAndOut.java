import java.util.*;
public class InAndOut{
	public static void main(String [] args){
		System.out.println("sads1");
		System.out.print("sdsds2");
		System.out.print("sdsds3");
		//println 输出并换行  print输出 括号中必须有值
		Scanner sc=new Scanner(System.in);
		String s=sc.next();//等待用户输入,获取在控制台上输入的内容,并转化成字符串
		System.out.println(s+"22222");
		int num=sc.nextInt();
		System.out.println(num*2);
		// nextDouble() nextBoolean() 没有char类型的nextChar()
	}	
}