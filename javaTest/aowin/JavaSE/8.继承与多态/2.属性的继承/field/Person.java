package com.aowin.field;
//父类
public class Person {
	public String name="person";//定义初始化
	
}
class Student extends Person{
	int age;
	//属性隐藏（覆盖 ）：子类中定义与父类同名的属性 父类同名属性被隐藏（覆盖）
	public String name="student";
	
	public void print() {
		//this:指代的当前对象的引用
		//super:指代当前对象的父类引用
		System.out.println(this.name);
		//子类中想要访问父类被隐藏的 属性 通过super关键字
		System.out.println(super.name);
		
	}
}

