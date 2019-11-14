package com.aowin.test;

public abstract class Animal {
	/*

	 * 抽线类和普通类的区别:
	 * 	1.不能创建对象,但是拥有构造器
	 *  2.抽象类中可以有抽象方法,抽象方法指的是没有方法体的方法,并且多一个abstract关键字
	 *  	但是如果一个类继承了该抽象类,那么必须重写当前抽象类的所有抽象方法
	 *  	或者子类也变成抽象类
	 *  
	 */ 
	// 注意:final 和abstract不能一起连用
		//abstract修饰方法时,不能与static,private连用
	public  void fun1() {
		
	}
	//public abstract void fun2();
	 abstract void run();

}
