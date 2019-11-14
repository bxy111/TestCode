package com.aowin.map;

import java.util.Hashtable;

//HashTable: 线程安全  键和值都不可以为null
public class HashTableTest {

	public static void main(String[] args) {
		Hashtable ht=new Hashtable<>();
		
		ht.put("hello", 123);
//		ht.put("123", null);//null不能作为值
		ht.put(null, "222");//null不能作为键
		
		System.out.println(ht);

	}

}
