package com.aowin.constructor;

public class Person {
	int id=10;
	/*public Person() {
		System.out.println("person����");
	}*/
	
	public Person(int id) {
		this.id=id;
	}
	
}
class Student extends Person{
	//���������ܱ��̳� ,���췽��������Ҫ��������ͬ
	//����ÿ���������ж�Ĭ�ϵ����˸����޲εĹ�������jvm�Զ���ӣ� ������󴴽�ǰҪ�ȰѸ�������Գ�ʼ����
	//��ʼ��˳���ȸ��������
	/*public Student() {
		//������ڵ�һ�� ��ʼ���Ķ���Ҫ�������
		//super();//���ø����޲ι��췽������ʡ�� Ĭ������������  
		System.out.println("student����...");
	}*/
	
	//��������û���޲ι�����ʱ ���๹�����о͵��ֶ����ø�������������
	public Student(int id) {
		//û�п���չ��
		//super(1001);//��ʾ�ĵ��ø����вι�����
		super(id);
	}

}