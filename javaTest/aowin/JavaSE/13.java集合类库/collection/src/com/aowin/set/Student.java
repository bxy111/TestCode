package com.aowin.set;

public class Student {
	private int id;
	private String name;
	private int age;
	
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	//重写hashcode()
	@Override
	public int hashCode() {
//		return 100; 效率低 这个方法没有判断能力
		return id+age+name.compareTo("a");
	}
	
	//重写equals()
	@Override
	public boolean equals(Object obj) {
		Student stu=(Student)obj;
		if(this.age==stu.age && this.id==stu.id && this.name.equals(stu.name)) {
			return true;//就认为是同一个对象
		}
		return false;//不同对象
	}
	
	
}
