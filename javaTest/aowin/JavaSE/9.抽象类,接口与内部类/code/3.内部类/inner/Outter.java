package com.aowin.inner;

import com.aowin.interfaces.USB;

public class Outter {
	public int numa;
	private int numb;
	//�����ڲ���
	//���������ⲿ������Ժͷ���
	//�ⲿ�������Ҫʹ���ڲ��������,�ȴ����ڲ���Ķ���,ͨ���ڲ������ʹ���ڲ�������԰���private
	public  class Inner{
		private int innera;
		public int innerb;
		public void fun1() {
			System.out.println(numb++);
		}
	}
	public void use() {
		Inner i=new Inner();
		System.out.println(i.innera++);
	}
	//��̬�ڲ���
	//ֻ��ʹ���ⲿ���еľ�̬����
	public static class Inner2{
		public void fun3() {
			int a=10;
			//System.out.println(numa);
		}
	}
	//�ֲ��ڲ���
	//û��Ȩ��,ֻ���ڵ�ǰ�����д���
	//�ֲ��ڲ�����ʹ�÷����еľֲ�����ʱ,�����޸���ֵ
	public void fun4() {
		int a=10;
		class inner3{
			public void fun5() {
				System.out.println(numa+numb);
				System.out.println(a);
			}
		}
	}
	//�����ڲ���
	//�൱�ڴ���һ��û�����ֵ��� ʵ����USB�ӿ�,��д�˽ӿ��еķ���,�ø��ӿ�����ָ���������
	public void fun6() {
		USB u=new USB() {

			@Override
			public void fun1() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void fun2() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}