package com.scm.filter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SendCodeListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		 Queue<String> phones = new LinkedList<String>();
		// 换成阻塞队列
		 BlockingQueue<String> phones = new LinkedBlockingDeque<String>();
		 sce.getServletContext().setAttribute("phones", phones);
		 // 开启一个 线程
		 new Thread(){
			 @Override
			 public void run() {
				while(true) {
					String phone;
					try {
						phone = phones.take();// 阻塞式  取不到值 阻塞
						System.out.println("队列取出"+phone);
						if(phone != null) {
							System.out.println(phone+"---->短信发送成功");
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		 }.start();
		 
		
	}

}
