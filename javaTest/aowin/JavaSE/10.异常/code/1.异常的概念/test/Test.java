package com.aowin.test;

public class Test {
	/*
	 * 异常:由于程序的原因出现的一种中断正常指令流的事件
	 * 
	 * 
	 * 
	 * */
	/* 
	 * 常见的异常:
	 * 		java.lang.ArrayIndexOutOfBoundsException:数组索引越界异常
	 * 		java.lang.StringIndexOutOfBoundsException:字符串索引越界异常
	 * 		java.lang.NullPointerException:空指针异常
	 * 		java.lang.ArithmeticException:算术异常
	 * 		java.lang.ClassCastException:类型转化异常
	 * */
	public static void main(String[] args) {
		/*int a[]=new int[10];
		for(int i=0;i<20;i++) {
			System.out.println(a[i]);
		}*/
		/*int a[]=null;
		Student s=null;
		System.out.println(a[0]);*/
		/*System.out.println(1/0);*/
	/*	Son s=new Son();
		Father f=s;
		//Father f1=new Father();
		s=(Son)f1;
		Son s2=(Son)f;*/
		fun();
		String str="asd";
		System.out.println(str.charAt(5));
	}
	public static void fun() {
		int a[]=new int[-10];
		System.out.println("方法中输出");
	}
}
