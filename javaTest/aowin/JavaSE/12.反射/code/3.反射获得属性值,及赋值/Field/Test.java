package com.aowin.Field;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//ͨ���������������ֵ�������Ը�ֵ
		Student s=new Student();
		Class c=Student.class;
		//ֻ�ܻ��public Ȩ�޵�����
		Field f=c.getField("y");
		//�������ֵ
		System.out.println(f.get(s));
		//�����Ը�ֵ
		f.set(s, 1000);
		System.out.println(f.get(s));
		Field f2=c.getDeclaredField("x");
		f2.setAccessible(true);
		System.out.println(f2.get(s));
		Field f3=c.getField("g");
		//��̬���� �������Ϊnull
		System.out.println(f3.get(null));
		//���Ϊ����,�����޸�ֵ,����ᱨ�� java.lang.IllegalAccessException
//		f3.set(null, 11);
		//�������publicȨ�޵�����,�����̳�����
		Field [] fd=c.getFields();
		/*for(int i=0;i<fd.length;i++) {
			System.out.println(fd[i]);
		}*/
		//�������Ȩ�޵�����,�������̳�����
		Field [] fd1=c.getDeclaredFields();
		for(int i=0;i<fd1.length;i++) {
			System.out.println(fd1[i]);
		}
		/*
		 * ͨ������������ֵ�������Ը�ֵ
		 * 	1.ͨ��class�����getField(String name)���õ�Field���͵Ķ���
		 * 		ע��:nameΪ������
		 *  2.ͨ��f.get(Object obj)�������õ�����ֵ
		 *  	ע��:objΪ�����������Ķ���,���Ϊ��̬����,obj����Ϊnull
		 *    ͨ��f.set(Object obj,Object value)������Ϊ���Ը�ֵ
		 *    	ע��:valueΪ�������Ե�ֵ
		 *    
		 * ������Ե�Ȩ�޲���public,ʹ��getDeclaredFiled();
		 * ���Ȩ�޲���,��Ҫ��Ȩ��
		 * getFields()��������publicȨ�޵�����,�����̳�����
		 * getDeclaredFields();��������Ȩ�޵�����,�������̳�����
		 * 
		 * 
		 * 
		 * */
		
		
	}
}
