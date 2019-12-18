package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet不是线程安全的
 * 多线程单实例 : servlet对象中如果存在一个共享的全局变量，而多个线程对这个变量去进行操作 可能会引发线程安全问题
 * 
 * 解决 线程安全问问题
 * 1.使用同步  效率低
 * 2.implements SingleThreadModel 标记接口   降低服务器性能
 * 3.不要使用全局变量 
 */
@WebServlet("/log")
public class LoginServlet extends HttpServlet implements SingleThreadModel{
	private static final long serialVersionUID = 1L;

	//String name;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.使用同步
		/*synchronized (this) {
			name = request.getParameter("account");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.print(name);
			out.flush();
			out.close();
		}*/
		
		
		String name = request.getParameter("account");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(name+this);
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
