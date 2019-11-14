package com.aowin.Field;

public class Father {
	private int a=10;
	public int b=11;
	int c=12;
	protected int d=13;
	public Father() {
		// TODO Auto-generated constructor stub
	}
	private Father(String name) {
		
	}
	public void eat1() {
		System.out.println("eat1");
	}
	private void eat2() {
		System.out.println("eat2");
	}
	void eat3() {
		System.out.println("eat3");
	}
	protected void eat4() {
		System.out.println("eat4");
	}
}
