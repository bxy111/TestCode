package com.aowin.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*不可以
		 * Class c=Class.class;
		Constructor con=c.getDeclaredConstructor(ClassLoader.class);
		con.setAccessible(true);
		Object o=con.newInstance(null);
		System.out.println((Class)o);*/
		Student s=new Student();
		String s2="sd";
		Father f=new Student();
		Class c=Student.class;
		Class fc=Father.class;
		//参数为一个对象,判断参数对象是否属于当前的class对象所代表的那个类
		System.out.println(c.isInstance(f));
		System.out.println(fc.isInstance(s));
		//instanceof 关键字,判断一个对象是否属于一个类,如果两个类没有关系,会报错
		System.out.println(f instanceof Student);
	}
}
