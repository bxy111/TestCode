package com.aowin.type1;

public class ThreadMethod2 {
	public static void main(String[] args) {
		//join():其它线程先执行
		//yield()
		T6 t6 = new T6();
		
		
		T7 t7 = new T7();
		t7.setPriority(Thread.MAX_PRIORITY);
		t7.setT(t6);
		
		t7.start();
		t6.start();
		
		System.out.println("main的优先级：" + Thread.currentThread().getPriority());//5
	}

}

class T6 extends Thread{
	
	
	public void run() {
		for(int i=1;i<10;i++) {
			System.out.println("T6====" + i);
		}
	}
}

class T7 extends Thread{
	private Thread t;
	
	public void setT(Thread t) {
		this.t = t;
	}
	
	public void run() {
		for(int i=10;i<20;i++){
			System.out.println("T7====" + i);
			if(i==15) {
				try {
					t.join();  //线程t先执行，执行完毕后，当前线程继续执行
					//t.yield();  //当前线程暂时停止执行，接下来继续抢占执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


