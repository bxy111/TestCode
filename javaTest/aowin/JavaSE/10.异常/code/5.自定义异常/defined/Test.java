package com.aowin.defined;

import java.util.Scanner;

public class Test {
	/* 
	 * 当一个类继承了RuntimeException,那么当前类为运行时异常
	 * 当一个类直接继承了Exception,那么当前类为编译器异常
	 * 
	 * throw:在当前类中抛出一个新的异常对象,一般是写在不满足情况的条件中
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		ATM a=new ATM();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入密码:");
		String psw=sc.next();
		System.out.println("请输入数字:");
		int count=sc.nextInt();
		try {
			a.in(psw, count);
		} catch (PasswordMismatchException e) {
			System.out.println("密码不正确,请重新输入");
		} catch (EnvironmentSecurityException e) {
			System.out.println("环境不安全,退出...");
			e.printStackTrace();
			return;
		}
		System.out.println("请输入操作: 1.存钱 2.取钱 3.查询 4.退出");
		int num=sc.nextInt();
		if(num==1) {
			System.out.println("请输入数量:");
			double m=sc.nextDouble();
			a.add(m);
		}else if(num==2) {
			System.out.println("请输入数量:");
			double m=sc.nextDouble();
			a.get(m);
		}else {
			return;
		}
	}
}
