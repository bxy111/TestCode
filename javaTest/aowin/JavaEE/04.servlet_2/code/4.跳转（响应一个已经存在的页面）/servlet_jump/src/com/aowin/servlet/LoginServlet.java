package com.aowin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.UserDao;
import com.aowin.model.User;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取请求参数
		String account = req.getParameter("account");
		String password= req.getParameter("password");
		
		//jdbc连接校验 select * from user where account=? and password=?
		try {
			User u = new UserDao().checkUser(account, password);
			if(u==null) {//表明账号密码错误
				//回到登录界面
				//跳转（响应一个已经存在的页面）
				//1.服务器端跳转（请求转发）  一次请求  地址栏不变
				//相对路径  相对于当前页面的路径
				/*RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, resp);*/
				//绝对路径  以/开头   /=http://localhost:8080/servlet_jump/
				//req.getRequestDispatcher("/login.html").forward(req, resp);
				
				//2.客户端跳转（重定向）  两次请求   地址栏不变
				//相对路径
				//resp.sendRedirect("login.html");
				//绝对路径 以/开头   /=http://localhost:8080/
				//获得工程路径的方法
				System.out.println(req.getContextPath());//   /servlet_jump
//				resp.sendRedirect("/servlet_jump/login.html");
				resp.sendRedirect(req.getContextPath()+"/login.html");
				
			}else {//表示成功
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//给客户端响应
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
