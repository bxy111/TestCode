package com.aowin.define;
//Ĭ�ϼ̳���Object
//Ȩ�����η�
//public�����е�  �ܱ��̳�
//private��˽�е� ���ܼ̳�
//protected���ܱ�����  ����̳� ͬ������
//Ĭ��Ȩ�ޣ���Ȩ�� ͬ���̳�
public class Person {
	//���ԣ�������
	public String name;
	public int age;
	private String sex;//˽�еĲ��ܱ��̳�
	
	int id;//Ĭ��Ȩ��
	protected int aaa;
	
	//����(��Ϊ)
	public void eat() {
		System.out.println("�Է�");
	}
	
	public void sleep() {
		System.out.println("˯��");
	}
}
