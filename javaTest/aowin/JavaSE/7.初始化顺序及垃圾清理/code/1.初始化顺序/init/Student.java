package com.aowin.init;

public class Student {
	public static int a=10;
	public int b=10;
	static {
		System.out.println("静态代码块1");
		a++;
	}
	
	static {
		System.out.println("静态代码块2");
		a*=2;
	}
	{
		a++;//23   25
		b++;
		System.out.println("构造快");
	}
	public Student() {
		a++;//24
		b++;
		System.out.println("构造器");
	}
	public Student(String name,int id) {
		System.out.println("有参数的构造器");
		this.name=name;
		this.id=id;
	}
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
