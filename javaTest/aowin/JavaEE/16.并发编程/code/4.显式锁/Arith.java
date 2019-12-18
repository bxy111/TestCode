package com.aowin.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Arith {
	
	private int number = 0;
	
	// 创建一个锁对象
	private Lock lock = new ReentrantLock();
	
	
	
	public void increament() {
		lock.lock(); // 锁住对象
		try {
			number ++;
		}finally {
			lock.unlock(); // 释放锁
		}
	}



	public int getNumber() {
		return number;
	}



	
	
}
