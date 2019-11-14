package com.aowin.util;

import java.util.Comparator;

//实现Comparator接口  成为一个比较器类
public class MyComparator implements Comparator<Anmal>{
	private String order;//升序或降序的 命令
	private String field;//排序的属性
	
	public MyComparator(String order, String field) {
		super();
		this.order = order;
		this.field = field;
	}

	@Override
	public int compare(Anmal o1, Anmal o2) {
//		return o1.getAge()-o2.getAge();//按照年龄升序排
		int result=0;
		//默认升序
		if("name".equals(field)) {
			result=o1.getName().compareTo(o2.getName());//按照名字升序
		}else if("age".equals(field)) {
			result=o1.getAge()-o2.getAge();//按照年龄升序
		}
		
		if("降序".equals(order)) {
			result=-result;
		}
		return result;
	}

}
