package com.aowin.init;

public class Test {
	//静态语句块
	static {
		a=12;
		
	}
	//构造快,在构造器之前执行
	{
		
	}
	public static int a=10;
	static {
		
	}
	/*
	 * 当虚拟机第一次见到一个类时,先加载该类,注意,类只加载一次:(第一次见到该类是指:* 
	 * (1)实例化该类的对象
	 * (2)调用该类的静态方法或静态属性时
	 * (3)Jvm启动时调用main()所在的类
	 * (4)调用java的某些反射的方法
	 * (5)初始化该类的子类时)
	 * 		1.装载:查找并加载类的二进制数据
	 * 		2.连接:
	 * 			1.验证:确保加载的数据的正确性
	 * 			2.准备:为类的静态变量分配内存,并初始化为默认值
	 * 			3.解析:将符号引用转化为直接引用
	 * 		3.初始化:按照源文件中的顺序收集类的静态数据,并为静态变量赋初始值
	 * 		4.new 关键字为对象分配合适的内存,并为对象的成员属性赋默认值
	 * 		5.执行构造块和构造器为属性赋初始值
	 * 		
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		/*Student s1=new Student("张三",1001);
		Student s2=new Student("李四",1002);*/
		//System.out.println(Student.a);
		Student s2=new Student();
		Student s=new Student("李四",1002);
		System.out.println(s2.a+" "+s.b+" "+s2.b);
		//25 11 12
	}
}
