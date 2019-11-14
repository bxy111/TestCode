package com.aowin.list;

import java.util.ArrayList;
import java.util.Iterator;

//ArrayList:底层实现是数组   修改和查询效率比较高  有序可重复
public class ArrayListTest {

	public static void main(String[] args) {
		//1.创建ArrayList对象
		ArrayList al=new ArrayList();
		
		//添加元素 在末尾元素
		al.add("hello");
		al.add(null);
		al.add(null);
		//指定位置添加元素
		al.add(0, "你好");
		al.add(123);//自动加包为Integer的对象 等同于al.add(new Integer(123));
		
		//删除元素  根据索引位置删除
		al.remove(0);
		//删除 第一次出现的指定元素  
		al.remove(null);
		//al.remove(123); 错误
		al.remove(new Integer(123));
		
		boolean flag = al.remove("world");
		System.out.println(flag);
		
		//修改  修改指定位置的元素
		al.set(0, "world");
		
		//查询 查询指定位置的元素
		Object value = al.get(1);
		System.out.println(value);
		
		
		//获得集合长度（元素个数）
		System.out.println(al.size());
		System.out.println(al);
		
		System.out.println("------------------------");
		//遍历
		//1.根据索引遍历
		for(int i=0;i<al.size();i++) {
			//输出 当前正在遍历的元素
			System.out.println(al.get(i));
		}
		
		//2.forEach循环（快速for循环）
		/*int[] arr= {1,2,3,4,5};
		for(int a:arr) {
			System.out.println(a);
		}*/
		System.out.println("-----------------------");
		for(Object obj:al) {
			System.out.println(obj);
		}
		
		System.out.println("------------------------");
		//3.迭代器遍历
		//先获取迭代器
		Iterator it = al.iterator();
		while(it.hasNext()) {
			Object obj = it.next();//得到 当前迭代的 元素
			System.out.println(obj);
		}
		
	}

}
