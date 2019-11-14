package com.aowin.type1;

public class Test {

	public static void main(String[] args) {
		//创建线程对象
		MyThread t = new MyThread();
		
		//t.run();  //方法调用，不会产生线程
		//启动一个新的线程
		t.start();
		
		
		//runnable接口
		//创建线程任务对象
		ThreadTask task = new ThreadTask();
		//创建线程对象
		Thread t2 = new Thread(task);

		//启动线程
		t2.start();
	}

}

//创建线程的方式：
//1.继承线程的类：Thread，重写run方法
//2.实现接口Runnable，实现方法run

//对比：直接继承Thread，更简单，在方法中的this就是线程对象
	//在实现接口的类中this不是线程对象
     //java中类之间是单继承，实现接口扩展性更好


class MyThread extends Thread{

	public void run() {
		System.out.println("线程的任务。。。。");
		
	}
	
}

class ThreadTask implements Runnable{
	@Override
	public void run() {
		System.out.println("要执行的线程任务。。。");
		
	}
}


