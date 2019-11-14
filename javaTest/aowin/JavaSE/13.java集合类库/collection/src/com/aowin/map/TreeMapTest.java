package com.aowin.map;

import java.util.TreeMap;

//TreeMap:二叉树  键要求有自然顺序
public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap ts=new TreeMap();
		
		ts.put("abc", 11);
		ts.put("ac", "hello");
//		ts.put(null, "hello");//null不能作为键
		ts.put("cc", null);//null可以作为值
		
		
		System.out.println(ts);
	}

}
