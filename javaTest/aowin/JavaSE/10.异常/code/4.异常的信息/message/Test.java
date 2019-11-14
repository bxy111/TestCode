package com.aowin.message;

public class Test {
	public static void main(String[] args) {
		try {
			//System.out.println(1/0);
			String  s="123";
			s.charAt(5);
		}catch(ArithmeticException e) {
			System.out.println("错误");
		}catch(StringIndexOutOfBoundsException e) {
			//e:指的是源码中抛出的异常对象
			//打印错误的提示信息
			System.out.println(e.getMessage());
			//打印堆栈追踪信息
			e.printStackTrace();
			
			
			
		}
	}
}
