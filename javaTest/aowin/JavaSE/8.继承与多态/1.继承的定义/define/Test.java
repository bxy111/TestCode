package com.aowin.define;

/*
 * 继承 extends：从已有类中派生出新的类 新的类称为子类 已有类为父类 子类可以继承父类的 属性和方法 也可以扩展自己的属性和方法
 * 符合 is a关系
 * java中类支持单继承 多重继承
 * 继承好处：
 * 1.提高代码复用性
 * 2.为多态提供前提
 * */
public class Test {

	public static void main(String[] args) {

		//创建学生对象
		Student stu=new Student();
		stu.age=10;
		System.out.println(stu.age);
		stu.eat();
		stu.study();
		
		
		//Person p=new Person();
		
	}

}
