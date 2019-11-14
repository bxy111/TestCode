package com.aowin.objectarray;

public class Test {
	public static void main(String[] args) {
		Classroom c=new Classroom("Èý½Ì",50,2);
		System.out.println(c.getSt()[49].getAge());
		Bookself b=new Bookself();
		System.out.println(b.getBook()[34]);
	}
}
