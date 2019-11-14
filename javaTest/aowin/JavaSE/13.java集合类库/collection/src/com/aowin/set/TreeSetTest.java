package com.aowin.set;

import java.util.TreeSet;

//TreeSet:由二叉树支持  要求有元素有自然顺序 存放的数据类型要一致
public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet ts=new TreeSet<>();
		/*ts.add(123);
		ts.add(456);
		ts.add(111);
		ts.add(11);*/
		
		/*ts.add("zhs");
		ts.add("hello");
		ts.add("world");
		ts.add("zz");*/
		
		//学生类中没有实现过Compareable接口 所以没有自然顺序 不能进行排序
		/*ts.add(new Student(1001,"zhs",12));
		ts.add(new Student(1002,"lsii",12));*/
		ts.add(new Person(10,"zhs"));
		ts.add(new Person(8,"lisi"));
		ts.add(new Person(20,"lisi"));
		
		
		System.out.println(ts.size());
		System.out.println(ts);

	}

}
