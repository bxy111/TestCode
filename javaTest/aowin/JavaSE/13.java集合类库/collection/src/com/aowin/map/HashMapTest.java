package com.aowin.map;

import java.util.HashMap;
import java.util.Set;

// HashMap:键和值都可以为null
public class HashMapTest {

	public static void main(String[] args) {
		HashMap hm=new HashMap<>();
		
		//增加元素
		hm.put("abc", "hello");
		hm.put(123, "hello");
//		hm.put(null, 123);
		hm.put("abc", 111);//建重复 值会被覆盖
		hm.put(null, null);
		
		//删除元素
		//根据键来删除
		hm.remove("abc");
		//根据键值对一起删
		hm.remove(null, null);
		
		//修改 根据键修改
		hm.put(123, "world");
		
		//查询 根据键获得值
		Object value = hm.get(new Integer(123));
		System.out.println(value);
		
		
		System.out.println(hm.size());
		System.out.println(hm);
		
		//遍历
		Set keys = hm.keySet();//获得所有的键 保存在set集中
		for(Object key:keys) {
			Object v =  hm.get(key);
			System.out.println(key+"="+v);
		}

	}

}
