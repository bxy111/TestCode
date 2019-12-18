package com.aowin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.UserDao;
import com.aowin.model.User;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/log2")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理登录过程的servlet
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//jdbc校验
		try {
			User u = new UserDao().checkUser(account, password);
			if(u==null) {//没有登录成功！
				//回到登录界面   提示信息
				request.setAttribute("error", "账号或密码错误！");
				request.getRequestDispatcher("/login.html").forward(request, response);
				
			}else {//登录成功
				//去首页   将用户登录信息保存在作用域
				request.getSession().setAttribute("user", u);
				response.sendRedirect(request.getContextPath()+"/indexServlet");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//出现异常也要给客户端跳转
			response.sendRedirect(request.getContextPath()+"/prompt.html");
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
