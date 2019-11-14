package com.aowin.define;
//默认继承自Object
//权限修饰符
//public：公有的  能被继承
//private：私有的 不能继承
//protected：受保护的  跨包继承 同包访问
//默认权限：包权限 同包继承
public class Person {
	//属性（特征）
	public String name;
	public int age;
	private String sex;//私有的不能被继承
	
	int id;//默认权限
	protected int aaa;
	
	//方法(行为)
	public void eat() {
		System.out.println("吃饭");
	}
	
	public void sleep() {
		System.out.println("睡觉");
	}
}
