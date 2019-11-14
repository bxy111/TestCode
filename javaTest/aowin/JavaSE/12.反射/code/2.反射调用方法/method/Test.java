package com.aowin.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student s1=new Student("张三");
		Student s2=new Student("李四");
		Class c1=Class.forName("com.aowin.method.Student");
		//通过class对象来获得指定方法,第一个参数为方法名,后面的可变长参数为方法的参数
		Method m1=c1.getMethod("speak1");
		// 通过invoke来调用方法,第一个参数为此方法所属的对象,静态方法时,第一个参数可以为null后面的可变长参数为方法的实参
		m1.invoke(s2);
		Method m2=c1.getMethod("f", int.class);
		m2.invoke(null, 5);
		Method m3=c1.getDeclaredMethod("speak3");
		m3.setAccessible(true);
		m3.invoke(s1);
		//会返回当前类的包括父类的所有public方法
		Method [] mt=c1.getMethods();
		for(int i=0;i<mt.length;i++) {
			System.out.println(mt[i]);
		}
		//会返回当前类的所有权限的方法,但是 不包括继承来的
		Method [] mt2=c1.getDeclaredMethods();
		for(int i=0;i<mt2.length;i++) {
			System.out.println(mt2[i]);
		}
		/*
		 * 反射调用方法:
		 * 1.通过class对象的getMethod(String name,Class.. args)来获得指定方法
		 * 		注意:name为想要获得的那个方法名
		 * 2.通过Method对象的invoke(Object obj,Object ...args)方法去调用该方法
		 * 		注意:obj指的是方法所属的对象,如果方法为静态方法,obj的值可以为null
		 * 
		 * 如果方法为其他权限,可以使用 class对象的getDeclaredMethod方法,使用之前需要打开权限
		 * getMethods 会返回所有public方法(也包括继承来的)
		 * getDeclaredMethods 会返回所有权限的方法(不包括继承来的)
		 * 
		 * 
		 * 
		 * */
		
	}
}
