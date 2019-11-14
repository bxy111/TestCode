package com.aowin.type1;

public class ThreadSetting {
	public static void main(String[] args) {
		//线程相关的属性配置
		
		//启动main方法，启动一个线程
		//当前线程
		Thread t = Thread.currentThread();
		System.out.println(t.getName());  //main
		
		T3 t3 = new T3();
		t3.setName("t3");  //设置线程的名字
		t3.setPriority(Thread.MAX_PRIORITY);  //设置优先级1-10之间的整数
		//如果所有 的前台线程任务都执行完毕，进程就可以结束了
		t3.setDaemon(false);  //设置是否是后台线程
		t3.start();
		
		Thread t4 = new Thread(new Task());
		t4.setName("t4");
		t4.setPriority(Thread.MIN_PRIORITY);
		t4.setDaemon(true); //t4设置为后台线程
		t4.start();
	}

}

class T3 extends Thread{
	@Override
	public void run() {
		//this就是线程对象
		//System.out.println(this.getName());  //Thread-0
		String name = this.getName();
		for(int i=0;i<1000;i++) {
			System.out.println(name +"==="+i);
		}
	}
}


class Task implements Runnable{
	@Override
	public void run() {
		//this不是线程对象
		Thread t = Thread.currentThread();
		//System.out.println(t.getName());  //Thread-1
		
		String name = t.getName();
		for(int i=1000;i<2000;i++) {
			System.out.println(name+"===="+i);
		}
	}
}
