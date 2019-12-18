package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aowin.model.User;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String username = request.getParameter("username");
		//通过输出流进行响应
		/*PrintWriter out = response.getWriter();
		if("zhs".equals(username) || "lisi".equals(username)) {
			out.print(1);
		}else {
			out.print(0);
		}
		out.flush();
		out.close();*/
		
		//servlet响应对象给客户端  
		//json格式：轻量级的数据转换格式  {"属性名":"属性值","属性名":"属性值",...}
		User u = new User("zhs","123","张三");
		JSONObject.toJSONString(u);
		//String json="{'account':'zhs','password':'123','name':'张三'}";
		
		ArrayList<User> al=new ArrayList<>();
		al.add(u);
		al.add(new User("lsii", "123", "李四"));
		
		//是集合或是数组数据 json [{'account':'zs'},{'account':lisi}]
		String json = JSONArray.toJSONString(al);
		System.out.println(json);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.print(u);
		out.print(json);//将json格式字符串响应给客户端
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
