package com.aowin.method;

public class Animal {
	
	public void bark() {
		System.out.println("����С�����");
	}
	
}
class Dog extends Animal{
	
	//�������ǣ���д�����̳й�ϵ�У����ඨ���븸�෽������ͬ��������ͬ������ֵ��ͬ��Ȩ�޲�����С�ķ�������֮Ϊ���� ��д
	//static final�ķ������ܱ���д
	
	//�������أ���һ�����У���������ͬ�������б�ͬ�����������ͣ�˳�� ��������
	public void bark() {
		System.out.println("����~");
	}

	public void print() {
		this.bark();
		//��Ҫȥ���ø��౻���ǵ� ���� ��super�ؼ���
		super.bark();
	}
}
