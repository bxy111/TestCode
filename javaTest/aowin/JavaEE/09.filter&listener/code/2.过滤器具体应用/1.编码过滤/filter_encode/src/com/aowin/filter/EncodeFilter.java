package com.aowin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//解决编码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//放行
		chain.doFilter(request, response);
		
	}

}
