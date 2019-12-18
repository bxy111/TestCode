package com.aowin.sche;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTest {
	
	public static void main(String[] args) {
		// 创建一个任务调度的连接池服务
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		
		Runnable command = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis()+"-->start done");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+"end done");
			}
		};
		// 1. 延时任务 延时指定之间之后执行任务
//		service.schedule(command, 5, TimeUnit.SECONDS);
		
		// 2. 周期任务 在固定的频率  执行周期任务 
//		service.scheduleAtFixedRate(command, 0, 5, TimeUnit.SECONDS);
		
		// 3. 周期任务 在固定的延时 执行周期任务 上一次任务结束之后 延时指定之间开始下一个任务
		service.scheduleWithFixedDelay(command, 0, 5, TimeUnit.SECONDS);
	}

}
