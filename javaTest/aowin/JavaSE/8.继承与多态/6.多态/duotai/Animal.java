package com.aowin.duotai;

public class Animal {
	int age=10;
	
	public void bark() {
		System.out.println("�����...");
	}
}
class Dog extends Animal{
	int age=1;
	@Override
	public void bark() {
		System.out.println("����~");
	}
	
	public void watchHome() {
		System.out.println("����");
	}
}
class Cat extends Animal{
	@Override
	public void bark() {
		System.out.println("����~");
	}
}
