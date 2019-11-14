package com.aowin.duotai;

public class Animal {
	int age=10;
	
	public void bark() {
		System.out.println("动物叫...");
	}
}
class Dog extends Animal{
	int age=1;
	@Override
	public void bark() {
		System.out.println("汪汪~");
	}
	
	public void watchHome() {
		System.out.println("看家");
	}
}
class Cat extends Animal{
	@Override
	public void bark() {
		System.out.println("喵喵~");
	}
}
