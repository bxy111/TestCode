package com.aowin.handle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	/*
	 * �����쳣�ķ�ʽ:
	 * 		1.try-catch���
	 * 			try{
	 * 				���ܳ����쳣�Ĵ���
	 * 			}catch(�쳣����  ������){
	 * 				�������ķ�ʽ(�����쳣֮��ִ�еĴ���)
	 * 			}catch(�쳣����1|�쳣����2|...  ������){
	 * 			}...
	 * 			��try�����г�����catch���ܲ�����쳣,����ֱ������catch������ִ��
	 * 			���û�г����쳣,��������ִ��,����catch����
	 * 			���ж��catch���ʱ,��һ���쳣���Ͳ��ܴ��ڵ��ڵڶ���
	 *     		
	 *     		try{
	 *     		}catch(){
	 *     		}finally{
	 *     			һ����ִ�е����,һ�㶼���һЩ���� �ر���Դ�Ĵ���
	 *     		}
	 *     2.throws:�׳��쳣
	 *     	 ��ǰ�������ܽ�����쳣,�����ϲ���ø÷����ķ������׳��쳣,����ϲ㷽�����ܽ��,Ҳ������
	 * 		д�ڷ����Ĳ����б�ĺ���
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
				System.out.println("��û�Ϲ�ѧ!����������");
			}catch(NumberFormatException e) {
				System.out.println("...");
			}finally {
				System.out.println("���ջ�ִ�е����");
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
			System.out.println("����");
			return a++;
		}finally {
			System.out.println("ִ��");
			return a++;// 12
		}
		
	}*/
	public static void fun1() throws ClassNotFoundException {
		Class.forName("sd");
		
	}
}
