package com.aowin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//继承HttpServlet  创建基于http协议的servlet
public class ThirdServlet extends HttpServlet{

	//get方式的请求调用doget() post方式的请求调用dopost()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("处理get请求...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("处理post请求");
	}
	
}
