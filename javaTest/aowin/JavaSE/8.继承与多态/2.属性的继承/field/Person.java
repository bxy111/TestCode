package com.aowin.field;
//����
public class Person {
	public String name="person";//�����ʼ��
	
}
class Student extends Person{
	int age;
	//�������أ����� ���������ж����븸��ͬ�������� ����ͬ�����Ա����أ����ǣ�
	public String name="student";
	
	public void print() {
		//this:ָ���ĵ�ǰ���������
		//super:ָ����ǰ����ĸ�������
		System.out.println(this.name);
		//��������Ҫ���ʸ��౻���ص� ���� ͨ��super�ؼ���
		System.out.println(super.name);
		
	}
}

