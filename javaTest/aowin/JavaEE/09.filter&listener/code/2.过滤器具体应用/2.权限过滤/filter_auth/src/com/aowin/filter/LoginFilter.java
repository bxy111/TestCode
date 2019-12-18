package com.aowin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断是否已经登录 --没有登录跳到登录界面  登陆了则放行通过
		//将请求和响应对象转为http协议的
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		Object obj = req.getSession().getAttribute("user");
		if(obj==null) {//未登录
			request.setAttribute("error", "请先登录后再访问");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {//登录
			chain.doFilter(request, response);
		}
				
	}

}
