package com.aowin.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Map<String, String> map = new HashMap<String, String>();
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		
		Runnable write = new Runnable() {
			@Override
			public void run() {
				
				lock.writeLock().lock(); // 获取写锁
				try {
					System.out.println(Thread.currentThread()+"-->写入数据");
					if(!map.containsKey("home")) {
						map.put("home", "hangzhou");
					}else {
						map.put("home", "shanghai");
					}
				}finally {
					lock.writeLock().unlock();
				}
			}
		};
		Runnable read = new Runnable() {
			@Override
			public void run() {
				lock.readLock().lock();
				try {
					System.out.println(Thread.currentThread()+"-->"+map.get("home"));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread()+"---读取完毕");
				}finally {
					lock.readLock().unlock();
				}
			}
		};
		
		
		service.submit(read);
		service.submit(write);
		
		
		
		
		
		
		
		
		
		
	}

}
