package com.aowin.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Arith arith = new Arith();
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				arith.increament();
			}
		};
		
		for(int i=1;i<=10000;i++) {
			service.submit(task);
		}
		
		service.shutdown();
		try {
			boolean b = service.awaitTermination(60, TimeUnit.DAYS);
			if(b) {
				System.out.println("执行结果："+arith.getNumber());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
