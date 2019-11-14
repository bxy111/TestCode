package com.aowin.type1;

public class RunTest {

	public static void main(String[] args) {
		//多个线程是抢占式执行
		T1 t1 = new T1();
		T2 t2 = new T2();

		t1.start();
		t2.start();
		
		//System.out.println("main.....");
		
		//main方法的线程
		for(int i=2000;i<3000;i++) {
			System.out.println("main====" + i);
		}
	}

}

class T1 extends Thread{

	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("T1====" + i);
		}
	}
}


class T2 extends Thread{
	@Override
	public void run() {
		for(int i=1000;i<2000;i++) {
			System.out.println("T2====" + i);
		}
	}
}
