package com.aowin.inner;

import com.aowin.interfaces.USB;

public class Outter {
	public int numa;
	private int numb;
	//常规内部类
	//可以是由外部类的属性和方法
	//外部类如果想要使用内部类的属性,先创建内部类的对象,通过内部类对象使用内部类的属性包括private
	public  class Inner{
		private int innera;
		public int innerb;
		public void fun1() {
			System.out.println(numb++);
		}
	}
	public void use() {
		Inner i=new Inner();
		System.out.println(i.innera++);
	}
	//静态内部类
	//只能使用外部类中的静态数据
	public static class Inner2{
		public void fun3() {
			int a=10;
			//System.out.println(numa);
		}
	}
	//局部内部类
	//没有权限,只能在当前方法中创建
	//局部内部类在使用方法中的局部变量时,不能修改其值
	public void fun4() {
		int a=10;
		class inner3{
			public void fun5() {
				System.out.println(numa+numb);
				System.out.println(a);
			}
		}
	}
	//匿名内部类
	//相当于创建一个没有名字的类 实现了USB接口,重写了接口中的方法,用父接口引用指向子类对象
	public void fun6() {
		USB u=new USB() {

			@Override
			public void fun1() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void fun2() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}