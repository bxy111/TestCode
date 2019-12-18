package com.aowin.automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
	
	private AtomicInteger num = new AtomicInteger();
	
	public void increament() {
		int n = num.incrementAndGet(); // +1操作
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		Test test = new Test();
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				test.increament();
			}
		};
		
		for(int i=0;i<10000;i++) {
			service.submit(task);
		}
		
		service.shutdown();
		try {
			boolean b = service.awaitTermination(1, TimeUnit.HOURS);
			if(b) {
				System.out.println(test.num.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
