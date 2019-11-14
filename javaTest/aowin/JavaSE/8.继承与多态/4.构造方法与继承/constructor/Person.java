package com.aowin.constructor;

public class Person {
	int id=10;
	/*public Person() {
		System.out.println("person构造");
	}*/
	
	public Person(int id) {
		this.id=id;
	}
	
}
class Student extends Person{
	//构造器不能被继承 ,构造方法名称需要与类名相同
	//子类每个构造器中都默认调用了父类无参的构造器（jvm自动添加） 子类对象创建前要先把父类的属性初始化好
	//初始化顺序：先父类后子类
	/*public Student() {
		//必须防在第一行 初始化的动作要最先完成
		//super();//调用父类无参构造方法可以省略 默认添加这条语句  
		System.out.println("student构造...");
	}*/
	
	//当父类中没有无参构造器时 子类构造器中就得手动调用父类其他构造器
	public Student(int id) {
		//没有可扩展性
		//super(1001);//显示的调用父类有参构造器
		super(id);
	}

}