package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.User;

/**
 * Servlet implementation class Index2Servlet
 */
@WebServlet("/indexServlet")
public class Index2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户登录信息
		Object o = request.getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		if(o==null) {
			out.print("<a href='login.html'>亲，请登录</a>");
		}else {
			//获取用户登录信息
			User u=(User)o;
			out.print("<p>欢迎您,"+u.getName()+"</p><a href='login.html'>退出</a>");
 		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
