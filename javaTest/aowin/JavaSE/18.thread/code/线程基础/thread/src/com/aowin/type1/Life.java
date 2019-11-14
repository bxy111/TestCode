package com.aowin.type1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Life {
	public static void main(String[] args) {
		T8 t8 = new T8();  //新建
		t8.start();  //就绪
	}

}

class T8 extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("t8开始执行");
			System.out.println("请在控制台上输入名字：");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String name = reader.readLine(); //阻塞式==>使线程进入阻塞状态
			System.out.println("name===" +  name);
			System.out.println("线程抢到cpu后，恢复执行");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
