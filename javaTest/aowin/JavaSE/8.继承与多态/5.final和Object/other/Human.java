package com.aowin.other;

//final:�ؼ��� ���������η� ���������࣬����������
//final�����಻�ܱ��̳�
//final���α�����ʾ����,ֻ�ܸ�ֵһ��
//final���η������ܱ���д

//һ�������û��ֱ�Ӽ̳���������Ĭ�ϼ̳���Object��
public /*final */ class Human /*extends Object*/{
	private String name;
	private int age;
	
	//�����ĳ�ʼ�������󴴽�֮ǰ�������븳ֵ
	//1.�����ʼ��
	//2.���췽����ʼ��  ÿһ����������Ҫ�и�ֵ���
//	final int NUMBER=100;
	final int NUMBER;
	
	public Human() {
		NUMBER=100;
	}
	public Human(String name, int age) {
		this();
//		NUMBER=101;
		this.name = name;
		this.age = age;
	}

	public final void eat() {
		
	}
	//��дtoString��������ӡ�����ʱ���������������Ч��Ϣ �����ǵ�ֵַ
	/*@Override
	public String toString() {
		return "Human[name="+this.name+",age="+this.age+"]";
	}*/
	
	
}
class Teacher extends Human{
	/*public void eat() {
		
	}*/
}

