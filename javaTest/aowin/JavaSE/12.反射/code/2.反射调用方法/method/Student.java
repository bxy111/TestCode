package com.aowin.method;

public class Student extends Father {
	static {
		System.out.println("��̬�����");
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
		System.out.println("�޲����Ĺ�����"+s+a);
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
