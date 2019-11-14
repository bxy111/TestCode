package com.aowin.string;

public class StringBuilderTest {
	public static void main(String[] args) {
		//StringBuilder也是一个字符串,可变的
		StringBuilder sb1= new StringBuilder("asd");
		StringBuilder sb2= new StringBuilder("asd");
		//StringBuilder是线程不安全的 StringBuffer是线程安全的
		StringBuffer sbf=new StringBuffer();
		System.out.println(sb1.equals(sb2));
		m(sb1);
		System.out.println(sb1);
	}
	public static void m(StringBuilder sb) {
		//字符串追加
		sb.append("ss");
		System.out.println(sb);
	}
}
