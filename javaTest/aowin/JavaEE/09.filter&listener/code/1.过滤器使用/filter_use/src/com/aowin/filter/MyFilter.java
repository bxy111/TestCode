package com.aowin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//过滤器类：实现一个javax.servlet.Filter
//同一个资源可以有多个过滤器来过滤  顺序：配置文件按照映射部分的顺序过滤
//一个过滤器可以过滤多个资源
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("执行过滤任务...");
		
		//放行通过
		arg2.doFilter(arg0, arg1);
	}
	
}
