package com.aowin.inner;

import com.aowin.interfaces.Computer;
import com.aowin.interfaces.USB;

public class Test {
	public static void main(String[] args) {
		Outter o=new Outter();
		//�ⲿ����.�ڲ����� ������= �ⲿ�����.new �ڲ�����();
		Outter.Inner i=o.new Inner();
		
		//��̬�ڲ��ഴ������ķ�ʽ:
		//�ⲿ����.�ڲ����� ������= new �ⲿ����.�ڲ�����();
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
