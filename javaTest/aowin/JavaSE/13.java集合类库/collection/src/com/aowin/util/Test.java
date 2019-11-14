package com.aowin.util;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		ArrayList<Anmal> al=new ArrayList<>();

		al.add(new Anmal("xb",2));
		al.add(new Anmal("xh",3));
		al.add(new Anmal("db",1));
		
		//按照宠物年临升序排
		//1.实现自然排序的接口 
//		Collections.sort(al);//按照自然顺序排
		
		//2.比较器排序 实现Comparator接口
		MyComparator mc=new MyComparator("降序","age");//创建比较器对象
		Collections.sort(al,mc);
		System.out.println(al);
		
		
	}

}
