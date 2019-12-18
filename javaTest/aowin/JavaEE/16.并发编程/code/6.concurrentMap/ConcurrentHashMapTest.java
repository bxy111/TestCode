package com.aowin.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
		ConcurrentMap<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("home", "hangzhou");
		
		//新增方法  getOrDefault 获取一个key对应的值 如果key不存在就返回默认值
//		System.out.println(map.getOrDefault("home1", "zhejiang"));
		// putIfAbsent 如果原来已经有key存在则不替换
		map.putIfAbsent("home", "shanghai");
//		System.out.println(map.get("home"));
		
		// 删除指定的key 只有当value相同时 才会删除
		map.remove("home", "hangzhou");
		System.out.println(map.get("home"));
		
		
	}

}
