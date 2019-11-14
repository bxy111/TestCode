package com.aowin.test2;

public class Student {
	private int id;//私有的
	public  String name;//公共的
	String gender;//默认权限
	protected  int age;// 受保护的
	/*
	 * 私有的: 只能在当前类中使用
	 * 公共的: 同包中的类和不同包中的(同一个项目)类都可以使用
	 * 默认权限(包权限):同包中的类可以访问
	 * 受保护的:同包中的类或者 该类的子类可以访问
	 * 
	 * 
	 * */
	public  void m() {
		System.out.println(id);
	}
}
