public class DataType{
	public static void main(String []args){
		/*
			��������:
				������������
					����
						�ֽ��� byte   1�ֽ�   0
						������ short  2�ֽ�   0
						����   int    4�ֽ�   0
						������ long   8�ֽ�   0L
					������
						�����ȸ����� float  4�ֽ�  0.0f
						˫���ȸ����� double 8�ֽ�  0.0d
					��������
						boolean 1λ  false
					�ַ���
						char    2�ֽ� '\u0000'
				����(����)��������   null
					��
					�ӿ�
					����

		*/ 
		//javaǿ��������:�������ʱ������������������
		//�������ͱ���
		/*int a=10;
		//��������ͱ���
		short b=10;
		long c=10L;
		a=11;
		//������ʹ��֮ǰ���븳ֵ
		int d=8;
		System.out.println(d);
		float f=0.3f;
		double d1=0.5;
		boolean b1=true;
		char ch='a';//char�������ַ�����,�õ���������,������ֻ����һ���ַ�*/
		//------------------------------------------------------------------------------------
		//����֮���ת������
		//1.ǿ��ת��:���ȼ��ߵ������ȼ��͵�ת��
		//2.�Զ�ת��:���ȼ��͵������ȼ��ߵ�ת��
		/*int a=10;
		//��a��ֵ��ֵ��d
		double d=a;
		System.out.println(d);
		double a=10.8987;
		//��a��ֵ��ֵ��d
		int d=(int)a;
		System.out.println(d);
		byte b=1;
		byte b2=1;
		long b3=10L;
		//����֮��Ľ��������ȡ�����������ȼ���ߵ�,���������int����,��ô��������Զ�����Ϊint
		//b=b+b3;
		//System.out.println(b);
		float f=1.0f;
		f=f+b;
		float f1=1.1f;
		System.out.println(f1);*/
		int a=257;
		byte b=(byte)a;
		System.out.println(b);















	
	}
}