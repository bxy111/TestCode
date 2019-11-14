public class DataType{
	public static void main(String []args){
		/*
			数据类型:
				基本数据类型
					整型
						字节型 byte   1字节   0
						短整型 short  2字节   0
						整型   int    4字节   0
						长整型 long   8字节   0L
					浮点型
						单精度浮点型 float  4字节  0.0f
						双精度浮点型 double 8字节  0.0d
					布尔类型
						boolean 1位  false
					字符型
						char    2字节 '\u0000'
				引用(复合)数据类型   null
					类
					接口
					数组

		*/ 
		//java强类型语言:定义变量时必须声明其数据类型
		//定义整型变量
		/*int a=10;
		//定义短整型变量
		short b=10;
		long c=10L;
		a=11;
		//变量在使用之前必须赋值
		int d=8;
		System.out.println(d);
		float f=0.3f;
		double d1=0.5;
		boolean b1=true;
		char ch='a';//char类型是字符类型,用单引号引上,引号中只能有一个字符*/
		//------------------------------------------------------------------------------------
		//类型之间的转化问题
		//1.强制转换:优先级高的向优先级低的转换
		//2.自动转换:优先级低的向优先级高的转换
		/*int a=10;
		//将a的值赋值给d
		double d=a;
		System.out.println(d);
		double a=10.8987;
		//将a的值赋值给d
		int d=(int)a;
		System.out.println(d);
		byte b=1;
		byte b2=1;
		long b3=10L;
		//运算之后的结果的类型取操作数中优先级最高的,如果不高于int类型,那么结果类型自动提升为int
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