public class Test{
	public static void main(String []args){
		/*
			类:对一种事物的抽象概念
			对象:某一类事物的具体事例
			类:
				属性:有什么
				行为:能干什么
			学生类:
				属性:学号,姓名,性别,班级
				行为:睡觉,吃饭,学习

		*/	
		//创建对象
		//对象与对象之间是相互独立的
		Student s1=new Student();
		System.out.println(s1.id+"  "+s1.name+"  "+s1.classroom);
		s1.sleep();
		s1.study();
		Student s2=new Student();
		s2.id=1002;
		s2.name="张三";
		s2.classroom=3;
		System.out.println(s2.id+"  "+s2.name+"  "+s2.classroom);

	}
}