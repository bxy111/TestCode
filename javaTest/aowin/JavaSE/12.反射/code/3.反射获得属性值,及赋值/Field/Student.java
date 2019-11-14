package com.aowin.Field;

public class Student extends Father {
	int z=26;
	public int y=25;
	private int x=24;
	protected int w=23;
	public static final int g=10;
	static {
		System.out.println("静态代码块");
	}
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String s,int a) {
		this.name=s;
		this.id=a;
		System.out.println("无参数的构造器"+s+a);
	}
	public Student() {
		
	}
	Student(int a){
		
	}
	public Student(String a) {
		name=a;
	}
	private Student(double a) {
		
	}
	public void speak1() {
		System.out.println(name+":speak1");
	}

	void speak2() {
		System.out.println("speak2");
	}
	public static void f(int a) {
		System.out.println("f");
	}
	private void speak3() {
		System.out.println("speak3");
	}
	protected void speak4() {
		System.out.println("speak4");
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
