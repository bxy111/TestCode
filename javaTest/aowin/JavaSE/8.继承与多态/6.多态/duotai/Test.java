package com.aowin.duotai;

//��̬����ͬ�Ķ������ͬһ������������ͬ����Ӧ
//��Ҫ���� ��1.�̳�  2.������д  3.��������ָ���������
//�ô��������չ��
//��̬�󶨻��ƣ�ǰ�ڰ󶨹����У�����ʱ��������������ʲô�����ܵ���ʲô����  ���ڰ󶨣����У�������������Ҫ�����ĸ�����
public class Test {

	public static void main(String[] args) {
//		Dog d=new Dog();
		Animal an=new Dog();//��̬����
		an.bark();
		
		//���Բ��߱� ��̬�Ե� ����ֻ������
		System.out.println(an.age);
		
		
		//��̬�����ܵ������������еķ���
		Dog d=(Dog)an;//����ת��
		d.watchHome();
		
		
		Animal an2=new Cat();
		an2.bark();

		//��̬����
		//��̬��ʼ��
		Animal[] ans=new Animal[5];
		ans[0]=new Dog();
		ans[1]=new Cat();
		//��̬��ʼ��
		Animal[]  ans2= {new Cat(),new Dog(),new Cat()};
		
	}
}
