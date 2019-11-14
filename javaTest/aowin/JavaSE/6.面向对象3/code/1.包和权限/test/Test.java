package com.aowin.test;
import com.aowin.test2.*;
public class Test {
	public static void main(String[] args) {
		//类全名:包名+类名
		//package:指的是当前类所在的包
		//import:导包,让虚拟机找到当前使用的类所在的包
		com.aowin.test2.Student s1=new com.aowin.test2.Student();
		Teacher t=new Teacher();
		System.out.println();
	}
}
