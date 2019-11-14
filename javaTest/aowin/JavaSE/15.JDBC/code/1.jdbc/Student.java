package com.aowin.jdbc;

public class Student {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String department;
	private int classroom;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public Student(int id, String name, int age, String sex, String department, int classroom) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.department = department;
		this.classroom = classroom;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", department=" + department
				+ ", classroom=" + classroom + "]";
	}
	
}
