package com.aowin.test;

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
	protected Student(String a) {
		
	}
	private Student(double a) {
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
