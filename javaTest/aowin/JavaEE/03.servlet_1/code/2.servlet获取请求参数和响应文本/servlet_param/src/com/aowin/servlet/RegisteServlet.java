package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

public class RegisteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收数据  请求参数 参数名=参数值
		//1.接收单个请求参数
		/*String account=req.getParameter("account");
		System.out.println("账号："+account);
		//2.接收一个参数名对应多个值 getParametrValues()
		String[] pass = req.getParameterValues("password");
		System.out.println("密码："+pass[0]+"--"+pass[1]);*/
		
		//3.一次性获取所有请求参数 getParameterMap()
		Map<String,String[]> map=req.getParameterMap();
		//遍历 KeySet
		//遍历 EntrySet
		Set<Entry<String, String[]>> entrys = map.entrySet();//得到map中所有的映射
		for(Entry<String, String[]> en:entrys) {
			System.out.println(en.getKey()+"--"+Arrays.toString(en.getValue()));
		}
		
		//封装对象 -- jdbc添加数据库
		int i=1;//受影响行数
		
		//给客户端响应
		//以普通文本方式进行响应  以输出流的方式
		PrintWriter out = resp.getWriter();
		/*if(i==1) {
			out.print("success!");
		}else {
			out.print("fail!");
		}
		out.flush();
		out.close();*/
		
		//响应一个html页面
		out.print("<html>");
		out.print("<head><title>resut</title></head>");
		out.print("<body>");
		if(i==1) {
			out.print("<h2 style='color:green'>success!</h2>");
		}else {
			out.print("<h2 style='color:red'>fail!</h2>");
		}
		out.print("</body>");
		out.print("</html>");
		out.flush();
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
