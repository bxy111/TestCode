package com.aowin.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTest {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 10};
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 10};
		
		
		// 创建一个固定线程对象的线程池 
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		
		
		Future<Integer> future1 = service.submit(new AddCallable(arr1)); // 提交Callable任务
		Future<Integer> future2 = service.submit(new AddCallable(arr2)); // 提交Callable任务
		
		try {
			//阻塞式方法  会等Callable中的任务执行完成之后 执行该代码
			// 输出运算结果
			System.out.println(future1.get()+future2.get());
			service.shutdown(); // 退出程序
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
