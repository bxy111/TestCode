package com.aowin.type;

import java.util.Scanner;

public class Test {
	/*
	 * �쳣:
	 * 		�������쳣:
	 * 			��javacʱ���ֵ��쳣(��eclipse��,����һ����ͱ��쳣)
	 * 		����ʱ�쳣:
	 * 			������ִ�еĹ����г��ֵ��쳣
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
	
	//�ݹ�:�����Լ������Լ�
	public static void fun1() {
		fun1();
	}
}
