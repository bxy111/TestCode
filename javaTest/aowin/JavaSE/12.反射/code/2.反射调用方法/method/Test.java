package com.aowin.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Student s1=new Student("����");
		Student s2=new Student("����");
		Class c1=Class.forName("com.aowin.method.Student");
		//ͨ��class���������ָ������,��һ������Ϊ������,����Ŀɱ䳤����Ϊ�����Ĳ���
		Method m1=c1.getMethod("speak1");
		// ͨ��invoke�����÷���,��һ������Ϊ�˷��������Ķ���,��̬����ʱ,��һ����������Ϊnull����Ŀɱ䳤����Ϊ������ʵ��
		m1.invoke(s2);
		Method m2=c1.getMethod("f", int.class);
		m2.invoke(null, 5);
		Method m3=c1.getDeclaredMethod("speak3");
		m3.setAccessible(true);
		m3.invoke(s1);
		//�᷵�ص�ǰ��İ������������public����
		Method [] mt=c1.getMethods();
		for(int i=0;i<mt.length;i++) {
			System.out.println(mt[i]);
		}
		//�᷵�ص�ǰ�������Ȩ�޵ķ���,���� �������̳�����
		Method [] mt2=c1.getDeclaredMethods();
		for(int i=0;i<mt2.length;i++) {
			System.out.println(mt2[i]);
		}
		/*
		 * ������÷���:
		 * 1.ͨ��class�����getMethod(String name,Class.. args)�����ָ������
		 * 		ע��:nameΪ��Ҫ��õ��Ǹ�������
		 * 2.ͨ��Method�����invoke(Object obj,Object ...args)����ȥ���ø÷���
		 * 		ע��:objָ���Ƿ��������Ķ���,�������Ϊ��̬����,obj��ֵ����Ϊnull
		 * 
		 * �������Ϊ����Ȩ��,����ʹ�� class�����getDeclaredMethod����,ʹ��֮ǰ��Ҫ��Ȩ��
		 * getMethods �᷵������public����(Ҳ�����̳�����)
		 * getDeclaredMethods �᷵������Ȩ�޵ķ���(�������̳�����)
		 * 
		 * 
		 * 
		 * */
		
	}
}
