package com.aowin.objectarray;

public class Classroom {
	private String name;
	private int size;
	private int floor;
	private Student st[] ;
	
	public Classroom(String name, int size, int floor) {
		this.name = name;
		this.size = size;
		this.floor = floor;
		st=new Student[size];
		for(int i=0;i<st.length;i++) {
			st[i]=new Student("ÕÅÈý"+i,i+10);
			
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Student[] getSt() {
		return st;
	}
	public void setSt(Student[] st) {
		this.st = st;
	}
	
}
