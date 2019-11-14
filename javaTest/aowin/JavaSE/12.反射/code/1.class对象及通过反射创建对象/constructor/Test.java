package com.aowin.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//class对象是指程序运行时存放当前类信息的一个对象,每个类只有一个class对象,在类被加载时创建
		//通过反射来创建对象
		//1.获得当前类的class对象
		//获得class对象的三种方法
		//1.Class.forName("类的全名(包名+类名)"); 会加载类
		Class c1=Class.forName("com.aowin.constructor.Student");
		//2.类名.class 不会加载类
		Class c2=Student.class;
		/*//3.对象.getClass();
		Student s=new Student("s",2);
		Class c3=s.getClass();*/
		//2.直接创建对象
		//c1.newInstance(),会创建一个Object类型的对象,默认调用无参构造器,
		//如果当前类没有无参构造器,程序会报错InstantiationException
		//如果当前类没有权限访问指定类的构造器,程序会报错java.lang.IllegalAccessException
		/*Object o=c1.newInstance();
		Student s1=(Student)o;
		System.out.println(s1);
		*/
		//3.通过构造器创建对象
	/*	//c1.getConstructor(),可以获得指定参数列表的构造器,该方法的参数为Class类型,也就是当你需要获得参数为String类型的构造器时,需要传参String.class
		Constructor con=c1.getConstructor(String.class,int.class);
		//通过newInstance方法来创建对象,参数为具体的实参
		Object o1=con.newInstance("s",2);
		Student s2=(Student)o1;
		System.out.println(s2);*/
		//c1.getDeclaredConstructor(String.class,int.class),获得所有权限的构造器
		Constructor con=c1.getDeclaredConstructor(String.class,int.class);
		//打开权限
		con.setAccessible(true);
		Object o1=con.newInstance("s",2);
		Student s2=(Student)o1;
		System.out.println(s2);
		//会返回所有public权限的构造器
		Constructor[] cons1=c1.getConstructors();
		for(int i=0;i<cons1.length;i++) {
			System.out.println(cons1[i]);
		}
		//会返回所有权限的构造器
		Constructor [] cons2=c1.getDeclaredConstructors();
		for(int i=0;i<cons2.length;i++) {
			System.out.println(cons2[i]);
		}
		/*
		 * class对象:
		 * 		class对象就是每一个类在运行时记录着本身信息的对象,有且只有一个,在类加载时自动创建
		 * 		获得class对象的方式:
		 * 			1.Class.forName(完整类名(包名+类名)); 会加载类
		 * 			2.类名.class 不会加载类
		 * 			3.对象.getClass();
		 * 通过反射创建对象:
		 * 		1.直接通过class对象的newInstance()创建
		 * 			注意:class对象的newInstance()默认调用无参构造器,如果没有无参构造器,会报错
		 * 		2.获得构造器类型Constructor的对象 来创建
		 * 		步骤:
		 * 			1.获得Constructor类型的对象
		 * 				1.class.getConstructor(Class ... arg);
		 * 					注意:该方法的参数类Class类型的可变长参数,也就是当你需要获得参数为String类型的构造器时,需要传参String.class
		 * 						该方法只能获得public权限的构造器
		 * 				2.class.getDeclaredConstructor(Class ... arg);
		 * 					注意:该方法可以获得所有权限的构造器,如果权限不够,需要打开权限,con.setAccessible(true);
		 * 			2.通过构造器的newInstance()方法来创建对象
		 * 				con.newInstance(Object ... arg);
		 * 			3.强转成具体类型
		 * 
		 * 还可以通过class对象获得所有的构造器
		 * 	 1.c1.getConstructors(),会获得所有public权限的构造器
		 *   2.c1.getDeclaredConstructors();获得所有权限的构造器
		 * 		
		 * 
		 * 		
		 * 
		 * 
		 * */
		
	}
}
