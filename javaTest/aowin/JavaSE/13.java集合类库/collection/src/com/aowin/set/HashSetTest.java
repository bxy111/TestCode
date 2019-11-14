package com.aowin.set;

import java.util.HashSet;
import java.util.Iterator;

//HashSet:底层由hash表支持  无序 不可重复
public class HashSetTest {

	public static void main(String[] args) {
		HashSet hs=new HashSet<>();
		
		//增加
		/*hs.add("hello");
		hs.add("world");
		hs.add(123);
		hs.add(null);
		//hs.add(null);//重复元素会被覆盖
		
		//删除
		hs.remove("hello");*/
		
		
		
		//修改 查询 没有
			
		/*System.out.println(hs.size());
		System.out.println(hs);
		System.out.println("---------------------");*/
		//遍历
		//forEach
		/*for(Object obj:hs) {
			System.out.println(obj);
		}*/
		System.out.println("-----------------------");
		//迭代器
		/*Iterator it = hs.iterator();
		while(it.hasNext()) {
			Object o=it.next();
			System.out.println(o);
			//hs.remove(o);//不能操作底层集合 ConcurrentModificationException 并发修改异常
			//用迭代器本身的删除方法
			it.remove();//删除当前正在迭代的对象
		}

		System.out.println(hs);*/
		
		//HashSet中如何判断对象是否重复  hashcode() equals()
		//1.先调用对象的hashcode()返回一个hashcode值 如果值不同则认为是不同的元素 如果相同则执行第二步
		//2.调用对象的equals()去比较 返回true则认为是相同对象 返回false则认为是不同的
		hs.add(new Student(1001,"张三",12));
		hs.add(new Student(1002,"李四",12));
		hs.add(new Student(1001,"张三",12));
		//第一个张三和第二个 张三 编号相同名字相同年龄相同不管是几次new出来都希望认为是同一个人
		//重写对象的hashcode  equals()
		
		
		System.out.println(hs);
		
		
		
		
	}

}
