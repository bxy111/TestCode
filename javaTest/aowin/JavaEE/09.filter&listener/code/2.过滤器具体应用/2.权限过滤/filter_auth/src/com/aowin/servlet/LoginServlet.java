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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log/in")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account=req.getParameter("account");
		String password=req.getParameter("password");
		
		try {
			User u = new UserDao().checkUser(account, password);
			if(u==null) {
				req.setAttribute("error", "账号密码错误");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}else {
				req.getSession().setAttribute("user", u);
				resp.sendRedirect(req.getContextPath()+"/index.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
