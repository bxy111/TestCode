package com.aowin.defined;

import java.util.Scanner;

public class Test {
	/* 
	 * ��һ����̳���RuntimeException,��ô��ǰ��Ϊ����ʱ�쳣
	 * ��һ����ֱ�Ӽ̳���Exception,��ô��ǰ��Ϊ�������쳣
	 * 
	 * throw:�ڵ�ǰ�����׳�һ���µ��쳣����,һ����д�ڲ����������������
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		ATM a=new ATM();
		Scanner sc=new Scanner(System.in);
		System.out.println("����������:");
		String psw=sc.next();
		System.out.println("����������:");
		int count=sc.nextInt();
		try {
			a.in(psw, count);
		} catch (PasswordMismatchException e) {
			System.out.println("���벻��ȷ,����������");
		} catch (EnvironmentSecurityException e) {
			System.out.println("��������ȫ,�˳�...");
			e.printStackTrace();
			return;
		}
		System.out.println("���������: 1.��Ǯ 2.ȡǮ 3.��ѯ 4.�˳�");
		int num=sc.nextInt();
		if(num==1) {
			System.out.println("����������:");
			double m=sc.nextDouble();
			a.add(m);
		}else if(num==2) {
			System.out.println("����������:");
			double m=sc.nextDouble();
			a.get(m);
		}else {
			return;
		}
	}
}
