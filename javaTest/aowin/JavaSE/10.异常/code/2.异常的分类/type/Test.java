package com.aowin.type;

import java.util.Scanner;

public class Test {
	/*
	 * 异常:
	 * 		编译器异常:
	 * 			在javac时出现的异常(在eclipse中,代码一保存就报异常)
	 * 		运行时异常:
	 * 			程序在执行的过程中出现的异常
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		/*Class.forName("sdsd");*/
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		System.out.println(num1+num2);
	}
	
	//递归:方法自己调用自己
	public static void fun1() {
		fun1();
	}
}
