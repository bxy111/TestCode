package com.aowin.string;

public class StringBuilderTest {
	public static void main(String[] args) {
		//StringBuilderҲ��һ���ַ���,�ɱ��
		StringBuilder sb1= new StringBuilder("asd");
		StringBuilder sb2= new StringBuilder("asd");
		//StringBuilder���̲߳���ȫ�� StringBuffer���̰߳�ȫ��
		StringBuffer sbf=new StringBuffer();
		System.out.println(sb1.equals(sb2));
		m(sb1);
		System.out.println(sb1);
	}
	public static void m(StringBuilder sb) {
		//�ַ���׷��
		sb.append("ss");
		System.out.println(sb);
	}
}
