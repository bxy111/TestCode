package com.aowin.interfaces;

public interface USB  {
	/* 
	 * 接口:是一种合约,规定了实现了接口的类能干什么
	 * 
	 * 接口中的方法除了static 和 default 修饰的方法, 所有方法都是public abstract修饰的抽象方法
	 * 接口中的属性都是public static final 类型的
	 * 类与接口的关系是多实现的
	 * */
	int abc=10;
	public abstract void fun1();
	public void fun2();
	public static void fun3() {
		System.out.println("这是静态方法");
	}
	public default void fun4() {
		System.out.println("defualt方法");
	}
}
