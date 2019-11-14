package com.aowin.duotai;

//多态：不同的对象调用同一个方法产生不同的响应
//必要条件 ：1.继承  2.方法重写  3.父类引用指向子类对象
//好处：提高扩展性
//动态绑定机制：前期绑定过程中（编译时）看声明的类是什么决定能调用什么方法  后期绑定（运行）看具体对象决定要调用哪个方法
public class Test {

	public static void main(String[] args) {
//		Dog d=new Dog();
		Animal an=new Dog();//多态对象
		an.bark();
		
		//属性不具备 多态性的 属性只看声明
		System.out.println(an.age);
		
		
		//多态对象不能调用子类中特有的方法
		Dog d=(Dog)an;//向下转型
		d.watchHome();
		
		
		Animal an2=new Cat();
		an2.bark();

		//多态数组
		//动态初始化
		Animal[] ans=new Animal[5];
		ans[0]=new Dog();
		ans[1]=new Cat();
		//静态初始化
		Animal[]  ans2= {new Cat(),new Dog(),new Cat()};
		
	}
}
