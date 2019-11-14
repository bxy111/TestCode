package com.aowin.other;

//final:关键字 用来做修饰符 可以修饰类，变量，方法
//final修饰类不能被继承
//final修饰变量表示常量,只能赋值一次
//final修饰方法不能被重写

//一个类如果没有直接继承其他类则默认继承自Object类
public /*final */ class Human /*extends Object*/{
	private String name;
	private int age;
	
	//常量的初始化：对象创建之前常量必须赋值
	//1.定义初始化
	//2.构造方法初始化  每一个构造器都要有赋值语句
//	final int NUMBER=100;
	final int NUMBER;
	
	public Human() {
		NUMBER=100;
	}
	public Human(String name, int age) {
		this();
//		NUMBER=101;
		this.name = name;
		this.age = age;
	}

	public final void eat() {
		
	}
	//重写toString方法：打印对象的时候可以输出对象的有效信息 而不是地址值
	/*@Override
	public String toString() {
		return "Human[name="+this.name+",age="+this.age+"]";
	}*/
	
	
}
class Teacher extends Human{
	/*public void eat() {
		
	}*/
}

