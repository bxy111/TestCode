package com.aowin.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*������
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
		//����Ϊһ������,�жϲ��������Ƿ����ڵ�ǰ��class������������Ǹ���
		System.out.println(c.isInstance(f));
		System.out.println(fc.isInstance(s));
		//instanceof �ؼ���,�ж�һ�������Ƿ�����һ����,���������û�й�ϵ,�ᱨ��
		System.out.println(f instanceof Student);
	}
}
