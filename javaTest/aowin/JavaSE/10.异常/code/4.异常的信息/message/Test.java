package com.aowin.message;

public class Test {
	public static void main(String[] args) {
		try {
			//System.out.println(1/0);
			String  s="123";
			s.charAt(5);
		}catch(ArithmeticException e) {
			System.out.println("����");
		}catch(StringIndexOutOfBoundsException e) {
			//e:ָ����Դ�����׳����쳣����
			//��ӡ�������ʾ��Ϣ
			System.out.println(e.getMessage());
			//��ӡ��ջ׷����Ϣ
			e.printStackTrace();
			
			
			
		}
	}
}
