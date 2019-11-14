package com.aowin.list;

import java.util.LinkedList;

//LinkedList:底层是链表实现的    新增和删除效率比较高   有序可重复
public class LinkedListTest {

	public static void main(String[] args) {
		//和ArrayList一模一样 只是多了头和尾的操作
		LinkedList ll=new LinkedList<>();
		
		ll.addFirst("hello");
		ll.addFirst("world");
		
		Object obj=ll.removeFirst();
		System.out.println(obj);
		
		System.out.println(ll.size());
		System.out.println(ll);
		
	}

}
