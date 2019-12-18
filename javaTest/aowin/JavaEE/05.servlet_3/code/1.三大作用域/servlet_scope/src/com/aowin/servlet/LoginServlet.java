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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		
		//三大作用域（上下文环境）：存储数据  跳转时携带数据跳转  数据名  数据值  名称自定义
		//setAttribute()  getAttribute()  removeAttribute()
		
		//请求作用域 HttpServletRequest  作用范围 ：在一次请求中有效
		//常用来保存一般的查询数据或提示信息
		request.setAttribute("acc", account);
		
		//会话作用域 HttpSession  作用范围:一次会话中有效 会话：打开浏览器和服务器交互的过程 浏览器关闭时会话结束
		//常用来保存用户的登录信息
		HttpSession session = request.getSession();//获得session对象
		session.setAttribute("acc", account);
		//session.setAttribute("acc", "hhhh");//同一个作用域中数据名相同 则值会被覆盖
		session.setAttribute("bcc", "小明");//一个作用域中可以存放多个数据

		//全局作用域 ServletContext  作用范围：只要服务器不关 数据一直有效   
		//常放的是共享的数据 比如访问量 在线人数
		ServletContext application = session.getServletContext();//获得全局作用域对象
		application.setAttribute("visit", 1000);
		
		
		//跳转到首页(servlet)
		//服务器端跳转
		//request.getRequestDispatcher("/index").forward(request, response);
		//客户端跳转
		response.sendRedirect(request.getContextPath()+"/index");
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
