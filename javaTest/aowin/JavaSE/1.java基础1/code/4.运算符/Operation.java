public class Operation{
	public static void main(String []args){
		//1.算术运算符 + - * / % ++ --
		//int a=10;
		// ++符号相当于 自增1  --符号相当于自减1
		//a++;//++a;
		//当++符号在前面时,先自增,再参与运算,
		//当++符号在后面时,先取a的值参与运算(算术以及输出),再自增
		//System.out.println(++a);
		//System.out.println(a);
		//2.比较运算符 == >= <= != > < 结果为布尔类型
		//byte b=10;//== 符号暂时不能比较引用类型(String)
		//System.out.println(a==b);
		//3.逻辑运算符 & &&  | || !
		//逻辑符号两边都是 结果为布尔类型的条件  整个表达式的结果也为布尔类型
		// 短路:当条件1能够决定整个表达式的结果,那么就不判断条件2
		/*int a=10;
		int b =6;
		int c=9;
		int d=7;
		boolean result=a-- + ++b>--c+d++ &&--a>c++;
		System.out.println(result);// f 8 7 9 8
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);*/
		//4.赋值运算符 = += -= *= /= %=
		/*int a=10;
		a+=10;// a=a+10;
		byte b=1;
		b+=999;
		System.out.println(b);
		//5.条件运算符 三目运算符
		// 布尔类型的表达式?值1:值2;
		System.out.println(3<5?1:"否");
		//6.位运算符 &  |    ^    >>    <<
			//  与 或  异或  右移  左移
		System.out.println(3<<2);*/
		//异或:相同为0,不同为1
		char ch='b';
		char ch2='z';
		int num=ch;
		System.out.println(num);
		          
		
		
	}
}