<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false"%>
<%@ page import="com.aowin.model.User,java.util.Scanner" %>
<%-- <%@ page import="java.util.Scanner" %> --%>

<%@ include file="jiu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 三种directive指令 -->
	<!-- 1.page指令
		 页面脚本语言的指定 编码指定
		 导包 import
		errorPage:指定异常发生时跳转的页面
		isErrorPage:当前页面是否是错误页面
	 -->
	 
	 index.jsp
	<%
	/* User u=new User();
	Scanner scan=new Scanner(System.in); */
	User u=null;
	//u.getClass();
	%>
	
	<!-- 2.include指令
		将另一个页面的内容包含到当前页面中
	 -->
	 
	 <!-- 3.taglib指令
	 	用来引入外部标签库
	  -->
	 
</body>
</html>