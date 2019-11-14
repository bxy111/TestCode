package com.aowin.handle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	/*
	 * 处理异常的方式:
	 * 		1.try-catch语句
	 * 			try{
	 * 				可能出现异常的代码
	 * 			}catch(异常类型  变量名){
	 * 				解决问题的方式(捕获异常之后执行的代码)
	 * 			}catch(异常类型1|异常类型2|...  变量名){
	 * 			}...
	 * 			当try语句块中出现了catch所能捕获的异常,程序直接跳到catch语句块中执行
	 * 			如果没有出现异常,程序正常执行,不会catch语句块
	 * 			当有多个catch语句时,第一个异常类型不能大于等于第二个
	 *     		
	 *     		try{
	 *     		}catch(){
	 *     		}finally{
	 *     			一定会执行的语句,一般都会放一些关于 关闭资源的代码
	 *     		}
	 *     2.throws:抛出异常
	 *     	 当前方法不能解决的异常,就向上层调用该方法的方法中抛出异常,如果上层方法不能解决,也向外抛
	 * 		写在方法的参数列表的后面
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) throws ClassNotFoundException {
		/*Scanner sc=new Scanner(System.in);
		while(true) {
			try {
				String s1=sc.next();
				String s2=sc.next();
				int num1=Integer.parseInt(s1);
				int num2=Integer.parseInt(s2);
				System.out.println(num1/num2);
				break;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("你没上过学!请重新输入");
			}catch(NumberFormatException e) {
				System.out.println("...");
			}finally {
				System.out.println("最终会执行的语句");
			}
		}*/
		fun1();
	}
	/*public static int  fun() {
		int a=10;
		try {
			a++;
			System.out.println(1/0);
			a++;//12
			return a;
		}catch(ArithmeticException e) {
			System.out.println("错误");
			return a++;
		}finally {
			System.out.println("执行");
			return a++;// 12
		}
		
	}*/
	public static void fun1() throws ClassNotFoundException {
		Class.forName("sd");
		
	}
}
