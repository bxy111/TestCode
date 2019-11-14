package com.aowin.string;

public class StringTest {
	public static void main(String[] args) {
		/*int a=10;
		int arr[] = {1,2,3,4};
		String s="asd";
		//fun1(a);
		//fun1(arr);
		fun1(s);	
		System.out.println(s);*/
		//字符串拥有不可变型
		//字符串比较问题
		/*String s1="aa"+"a";
		String s2="aa";
		
		s2+="a";//通过在堆中生成新的StringBulider对象来拼接字符串,并转化成字符串
		String s5="aaa";
		String s3=new String("aaa");
		String s4=new String("aa");
		System.out.println(s2==s3);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println(s2==s5);
		System.out.println(s1==s5);*/
		/*String s1="aa";
		String s2="a";
		String s5="aaa";
		String s3=new String("aa");
		String s4=new String("a");
		System.out.println(s1+s2==s3+s4);
		System.out.println(s1+s2==s5);
		System.out.println(s1+"a"==s5);
		System.out.println(s1+s2=="aaa");
		System.out.println(s3+"a"==s5);// 
		System.out.println("a"+"aa"==s5);*/
		String s1="a"+"aa";
		String s2="aaa";
		String s3=new String("a"+"a"+"a");
		String s4=new String("aaa");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s3));
		System.out.println(s2==s3);
		System.out.println(s3==s4);//t f f f(t)
	}
	public static void fun1(int a) {
		a++;
		System.out.println(a);
	}
	public static void fun1(int [] a) {
		a[0]=10;
		System.out.println(a[0]);
	}
	public static void fun1(String s) {
		s+="sss";
		System.out.println(s);
	}
}