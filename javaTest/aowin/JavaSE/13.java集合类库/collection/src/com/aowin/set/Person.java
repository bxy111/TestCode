package com.aowin.set;

//自然顺序 --实现Comparable接口
public class Person implements Comparable {
	private int age;
	private String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Object o) {
		Person p=(Person)o;//ClassCastException   instanceof
		/*if(o instanceof Person) {//返回true表示o是person类的对象
			
		}*/
		
		//当前对象-obj对象 升序  反之降序
		return this.age-p.age;//按照年龄升序排列
//		return this.name.compareTo(p.name);//按照名字升序排
		//return new Double(this.score).compareTo(new Double(p.score));
		
	}
	
}
