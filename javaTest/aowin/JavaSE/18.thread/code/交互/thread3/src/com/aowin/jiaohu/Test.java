package com.aowin.jiaohu;

public class Test {

	public static void main(String[] args) {
		
		Object obj = new Object();
		
		//两个线程使用一个资源对象
		T1 t1 = new T1(obj);
		T2 t2 = new T2(obj);
		
		t1.start();
		t2.start();
	}

}

class T1 extends Thread{
	private Object obj;
	
	public T1(Object obj) {
		this.obj = obj;
	}

	public void run() {
		synchronized(obj) {
			System.out.println("t1获取obj的对象锁");
			for(int i=1;i<1000;i++) {
				System.out.println("t1====" + i);
				if(i%100==0) {
					try {
						obj.notify();  //唤醒其它线程（使用obj的进入wait状态的线程）
						System.out.println("t1进入wait状态");
						obj.wait();  //当前线程停止执行，释放对象锁
						//obj.wait(2000);  //
						System.out.println("t1解除wait状态");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}


class T2 extends Thread{
	private Object obj;
	
	public T2(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		synchronized(obj) {
			System.out.println("t2获取obj的对象锁");
			for(int i=1001;i<2000;i++) {
				System.out.println("t2====" + i);
				if(i%100==0) {
					try {
						obj.notify();
						System.out.println("t2进入wait状态");
						obj.wait();  //当前线程停止执行，释放对象锁
						//obj.wait(2000);  //设置等待时间
						System.out.println("t2解除wait状态");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
