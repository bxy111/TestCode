package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求乱码的解决  默认编码iso-8859-1
		//1.利用字符串重构
		//接收请求参数
		/*String account = req.getParameter("account");
		byte[] buf=account.getBytes("iso-8859-1");
		String str=new String(buf,"utf-8");
		System.out.println(str);*/
		
		//2.针对post请求  参数在请求体中  只要在获取请求参数前设置请求对象的编码
		/*req.setCharacterEncoding("utf-8");
		String  account=req.getParameter("account");
		System.out.println(account);*/
		
		//3.get请求  地址栏 utf-8
		// 如果乱码：在服务器配置文件server.xml中的<Connector >加属性URIEncoding="utf-8"
		String  account=req.getParameter("account");
		System.out.println(account);
		
		
		
		//响应乱码的解决
		//在响应之前对响应对象设置编码
		//设置浏览器的解析方式
		resp.setCharacterEncoding("utf-8");
		//跟meta标签功能一致  text/plain:普通文本   text/html:html内容    text/xml:xml内容  
		//resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//out.print("你好");
		//out.print("<html><head><meta charset='utf-8'></head><body>哈哈哈</body></html>");
		out.flush();
		out.close();
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
