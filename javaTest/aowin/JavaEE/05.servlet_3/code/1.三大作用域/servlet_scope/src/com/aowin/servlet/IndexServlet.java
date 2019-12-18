package com.aowin.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//生成食品  
		
		//去作用域中获取数据
		//1.请求作用域
		Object o1 = request.getAttribute("acc");
		System.out.println("request:"+o1);
		//2.会话作用域
		HttpSession session = request.getSession();
		Object o2 = session.getAttribute("acc");
		Object o3 = session.getAttribute("bcc");
		System.out.println("session:"+o2);
		System.out.println("session:"+o3);
		
		//3.全局作用域
		ServletContext application = session.getServletContext();
		Object o4 = application.getAttribute("visit");
		System.out.println("application:"+o4);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
