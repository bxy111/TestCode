package com.aowin.method;

public class Animal {
	
	public void bark() {
		System.out.println("动物叫。。。");
	}
	
}
class Dog extends Animal{
	
	//方法覆盖（重写）：继承关系中，子类定义与父类方法名相同，参数相同，返回值相同，权限不能缩小的方法，称之为方法 重写
	//static final的方法不能被重写
	
	//方法重载：在一个类中，方法名相同，参数列表不同（个数，类型，顺序） 叫做重载
	public void bark() {
		System.out.println("汪汪~");
	}

	public void print() {
		this.bark();
		//想要去调用父类被覆盖的 方法 用super关键字
		super.bark();
	}
}
