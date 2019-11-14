package com.aowin.type1;

public class ThreadMethod {
	public static void main(String[] args) {
		//线程的方法
		
		T5 t5 = new T5();
		t5.start();
		
		//获取当前线程
		Thread t = Thread.currentThread();
		
		//Thread.sleep让当前线程暂停执行，静态方法
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				//Thread.sleep(1000);  //单位是毫秒
				t5.sleep(1000);  //Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


class T5 extends Thread{
	@Override
	public void run() {
		for(int i=10;i<20;i++) {
			System.out.println("T5===="+i);
		}
	}
}
