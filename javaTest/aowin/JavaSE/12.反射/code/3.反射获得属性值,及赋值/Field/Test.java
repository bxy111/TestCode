package com.aowin.Field;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//通过反射来输出属性值及给属性赋值
		Student s=new Student();
		Class c=Student.class;
		//只能获得public 权限的属性
		Field f=c.getField("y");
		//获得属性值
		System.out.println(f.get(s));
		//给属性赋值
		f.set(s, 1000);
		System.out.println(f.get(s));
		Field f2=c.getDeclaredField("x");
		f2.setAccessible(true);
		System.out.println(f2.get(s));
		Field f3=c.getField("g");
		//静态属性 对象可以为null
		System.out.println(f3.get(null));
		//如果为常量,不能修改值,否则会报错 java.lang.IllegalAccessException
//		f3.set(null, 11);
		//获得所有public权限的属性,包括继承来的
		Field [] fd=c.getFields();
		/*for(int i=0;i<fd.length;i++) {
			System.out.println(fd[i]);
		}*/
		//获得所有权限的属性,不包括继承来的
		Field [] fd1=c.getDeclaredFields();
		for(int i=0;i<fd1.length;i++) {
			System.out.println(fd1[i]);
		}
		/*
		 * 通过反射获得属性值及给属性赋值
		 * 	1.通过class对象的getField(String name)来得到Field类型的对象
		 * 		注意:name为属性名
		 *  2.通过f.get(Object obj)方法来得到属性值
		 *  	注意:obj为该属性所属的对象,如果为静态属性,obj可以为null
		 *    通过f.set(Object obj,Object value)方法来为属性赋值
		 *    	注意:value为具体属性的值
		 *    
		 * 如果属性的权限不是public,使用getDeclaredFiled();
		 * 如果权限不够,需要打开权限
		 * getFields()返回所有public权限的属性,包括继承来的
		 * getDeclaredFields();返回所有权限的属性,不包括继承来的
		 * 
		 * 
		 * 
		 * */
		
		
	}
}
