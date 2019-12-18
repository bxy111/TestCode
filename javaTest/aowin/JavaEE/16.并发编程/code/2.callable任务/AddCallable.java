package com.aowin.callable;

import java.util.concurrent.Callable;
/**
 * 适用于包含返回值的线程
 * @author Administrator
 *
 */
public class AddCallable implements Callable<Integer>{
	
	private int[] arr;
	
	

	public AddCallable(int[] arr) {
		super();
		this.arr = arr;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i : arr) {
			Thread.sleep(1000);
			sum += i;
		}
		return new Integer(sum);
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	

}
