package com.aowin.test;

public class Test {
	/*
	 * �쳣:���ڳ����ԭ����ֵ�һ���ж�����ָ�������¼�
	 * 
	 * 
	 * 
	 * */
	/* 
	 * �������쳣:
	 * 		java.lang.ArrayIndexOutOfBoundsException:��������Խ���쳣
	 * 		java.lang.StringIndexOutOfBoundsException:�ַ�������Խ���쳣
	 * 		java.lang.NullPointerException:��ָ���쳣
	 * 		java.lang.ArithmeticException:�����쳣
	 * 		java.lang.ClassCastException:����ת���쳣
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
		System.out.println("���������");
	}
}
