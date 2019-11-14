package com.aowin.list;

import java.util.Stack;

//Stack:栈  先进后出
public class StackTest {

	public static void main(String[] args) {
		Stack s=new Stack();
		//入栈 push()
		s.push("hello");//栈底
		s.push(false);
		s.push("world");
		s.push("abc");//栈顶
		
		//出栈 pop() 将栈顶元素从栈中提取出来
		Object top = s.pop();
		System.out.println(top);
		
		//查看栈顶元素  peek()
		Object obj = s.peek();
		System.out.println(obj);
		
		//判断是否为空栈
		boolean f = s.empty();
		System.out.println(f);
		
		/*s.pop();
		s.pop();
		s.pop();
		s.pop();*/
		while(!s.empty()) {
			s.pop();
		}
		
		System.out.println(s);
		
	}

}
