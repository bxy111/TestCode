package com.aowin.interfaces;

public interface USB  {
	/* 
	 * �ӿ�:��һ�ֺ�Լ,�涨��ʵ���˽ӿڵ����ܸ�ʲô
	 * 
	 * �ӿ��еķ�������static �� default ���εķ���, ���з�������public abstract���εĳ��󷽷�
	 * �ӿ��е����Զ���public static final ���͵�
	 * ����ӿڵĹ�ϵ�Ƕ�ʵ�ֵ�
	 * */
	int abc=10;
	public abstract void fun1();
	public void fun2();
	public static void fun3() {
		System.out.println("���Ǿ�̬����");
	}
	public default void fun4() {
		System.out.println("defualt����");
	}
}
