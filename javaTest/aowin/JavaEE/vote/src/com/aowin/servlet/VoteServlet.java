package com.aowin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.User;
import com.aowin.service.VoteService;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/voteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理投票的过程
		//1.先判断用户有没有登录
		Object o = request.getSession().getAttribute("user");
		if(o==null) {
			request.setAttribute("error", "请先登录！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//表名是已经登录
		User u = (User)o;
		//获取用户提交的请求参数（心情）
		String mind = request.getParameter("vote");
		
		try {
			int n = new VoteService().vote(u.getAccount(), mind);
			if(n==1) {
				request.setAttribute("msg", "您已经投过票，请勿重复投票");
			}else if(n==2) {
				request.setAttribute("msg", "投票成功！");
			}else {
				request.setAttribute("msg", "投票失败！");
				
			}
			request.getRequestDispatcher("/index.html").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
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
