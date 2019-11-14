package com.aowin.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//class������ָ��������ʱ��ŵ�ǰ����Ϣ��һ������,ÿ����ֻ��һ��class����,���౻����ʱ����
		//ͨ����������������
		//1.��õ�ǰ���class����
		//���class��������ַ���
		//1.Class.forName("���ȫ��(����+����)"); �������
		Class c1=Class.forName("com.aowin.constructor.Student");
		//2.����.class ���������
		Class c2=Student.class;
		/*//3.����.getClass();
		Student s=new Student("s",2);
		Class c3=s.getClass();*/
		//2.ֱ�Ӵ�������
		//c1.newInstance(),�ᴴ��һ��Object���͵Ķ���,Ĭ�ϵ����޲ι�����,
		//�����ǰ��û���޲ι�����,����ᱨ��InstantiationException
		//�����ǰ��û��Ȩ�޷���ָ����Ĺ�����,����ᱨ��java.lang.IllegalAccessException
		/*Object o=c1.newInstance();
		Student s1=(Student)o;
		System.out.println(s1);
		*/
		//3.ͨ����������������
	/*	//c1.getConstructor(),���Ի��ָ�������б�Ĺ�����,�÷����Ĳ���ΪClass����,Ҳ���ǵ�����Ҫ��ò���ΪString���͵Ĺ�����ʱ,��Ҫ����String.class
		Constructor con=c1.getConstructor(String.class,int.class);
		//ͨ��newInstance��������������,����Ϊ�����ʵ��
		Object o1=con.newInstance("s",2);
		Student s2=(Student)o1;
		System.out.println(s2);*/
		//c1.getDeclaredConstructor(String.class,int.class),�������Ȩ�޵Ĺ�����
		Constructor con=c1.getDeclaredConstructor(String.class,int.class);
		//��Ȩ��
		con.setAccessible(true);
		Object o1=con.newInstance("s",2);
		Student s2=(Student)o1;
		System.out.println(s2);
		//�᷵������publicȨ�޵Ĺ�����
		Constructor[] cons1=c1.getConstructors();
		for(int i=0;i<cons1.length;i++) {
			System.out.println(cons1[i]);
		}
		//�᷵������Ȩ�޵Ĺ�����
		Constructor [] cons2=c1.getDeclaredConstructors();
		for(int i=0;i<cons2.length;i++) {
			System.out.println(cons2[i]);
		}
		/*
		 * class����:
		 * 		class�������ÿһ����������ʱ��¼�ű�����Ϣ�Ķ���,����ֻ��һ��,�������ʱ�Զ�����
		 * 		���class����ķ�ʽ:
		 * 			1.Class.forName(��������(����+����)); �������
		 * 			2.����.class ���������
		 * 			3.����.getClass();
		 * ͨ�����䴴������:
		 * 		1.ֱ��ͨ��class�����newInstance()����
		 * 			ע��:class�����newInstance()Ĭ�ϵ����޲ι�����,���û���޲ι�����,�ᱨ��
		 * 		2.��ù���������Constructor�Ķ��� ������
		 * 		����:
		 * 			1.���Constructor���͵Ķ���
		 * 				1.class.getConstructor(Class ... arg);
		 * 					ע��:�÷����Ĳ�����Class���͵Ŀɱ䳤����,Ҳ���ǵ�����Ҫ��ò���ΪString���͵Ĺ�����ʱ,��Ҫ����String.class
		 * 						�÷���ֻ�ܻ��publicȨ�޵Ĺ�����
		 * 				2.class.getDeclaredConstructor(Class ... arg);
		 * 					ע��:�÷������Ի������Ȩ�޵Ĺ�����,���Ȩ�޲���,��Ҫ��Ȩ��,con.setAccessible(true);
		 * 			2.ͨ����������newInstance()��������������
		 * 				con.newInstance(Object ... arg);
		 * 			3.ǿת�ɾ�������
		 * 
		 * ������ͨ��class���������еĹ�����
		 * 	 1.c1.getConstructors(),��������publicȨ�޵Ĺ�����
		 *   2.c1.getDeclaredConstructors();�������Ȩ�޵Ĺ�����
		 * 		
		 * 
		 * 		
		 * 
		 * 
		 * */
		
	}
}
