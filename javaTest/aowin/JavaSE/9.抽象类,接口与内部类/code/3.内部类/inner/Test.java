package com.aowin.inner;

import com.aowin.interfaces.Computer;
import com.aowin.interfaces.USB;

public class Test {
	public static void main(String[] args) {
		Outter o=new Outter();
		//外部类名.内部类名 变量名= 外部类对象.new 内部类名();
		Outter.Inner i=o.new Inner();
		
		//静态内部类创建对象的方式:
		//外部类名.内部类名 变量名= new 外部类名.内部类名();
		Outter.Inner2 i2=new Outter.Inner2();
		int a=10;
		USB u=new AAA();
		USB u1=new BBB();
		Computer com=new Computer();
		com.use(new AAA());
		com.use(new USB() {

			@Override
			public void fun1() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void fun2() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
