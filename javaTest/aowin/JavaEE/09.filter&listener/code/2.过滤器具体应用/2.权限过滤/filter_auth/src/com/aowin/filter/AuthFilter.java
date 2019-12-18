package com.aowin.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.User;
import com.aowin.service.AuthService;

public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//根据用户访问的资源结合用户权限判断用户是否能访问该资源
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//先获取用户访问的资源路径
		/*String uri=req.getRequestURI();//   /filter_auth/normal/nz.jsp
		StringBuffer url=req.getRequestURL();//   http://localhost:8080/filter_auth/normal/nz.jsp
		System.out.println(url);
		/*System.out.println(uri);*/
		
		String path=req.getServletPath();//  /normal/nz.jsp   /vip/bxqy.jsp
		User u =  (User)req.getSession().getAttribute("user");
		//调用业务层的方法来看用户是否有权限
		try {
			boolean flag = new AuthService().authCheck(u.getAccount(), path);
			
			if(flag) {//表示有权限
				chain.doFilter(request, response);//放行通过
			}else {//表示没权限
				//跳到提示充值界面
				resp.sendRedirect(req.getContextPath()+"/pay.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
