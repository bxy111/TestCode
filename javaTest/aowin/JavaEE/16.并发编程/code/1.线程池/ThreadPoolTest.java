package com.aowin.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
		// 1. 线程池 ：作用提高线程对象的复用性
		// 2. 创建线程池
		// 2.1 创建一个单一的线程对象的线程池对象  只管理一个线程对象
//		ExecutorService service = Executors.newSingleThreadExecutor();
		
		// 2.2创建一个可以创建多个线程对象的线程池 如果有现成的线程对象 直接用，没有的话创建新的 
		// 如果一个线程对象60s钟没用被使用，则将其对象移除
//		ExecutorService service = Executors.newCachedThreadPool();
		
		// 2.3 创建一个固定线程对象的线程池 
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		// 创建任务对象
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread()+"--->task 1 "+i);
					
				}
			}
		};
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread()+"--->task 2  "+i);
				}
			}
		};
		// 提交一个任务
		service.submit(task1);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		service.submit(task2);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		service.submit(task1);
//		service.submit(task2);
//		
		
		// 3. 退出程序
		service.shutdown(); // 会将之前要已经提交过的 任务全部执行完成之后 关闭程序 之后再提交的任务会被拒绝
		
//		service.submit(task1);
		
		try {
			// 阻塞方法 在shutdown方法调用后调用该方法 直到线程池中的任务执行完成或者时间超时之后执行之后的代码
			// 返回值true 表示所有任务执行完成 false表示超时，有部分任务没有执行完
			boolean b = service.awaitTermination(200, TimeUnit.SECONDS);
			System.out.println(b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
