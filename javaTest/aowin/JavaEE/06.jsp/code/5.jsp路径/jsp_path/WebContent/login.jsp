<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//工程发布路径   /jsp_path
	// http://localhost:8080/jsp_path/
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" ><!-- 当前页面 所有相对路径都基于basePath -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		http://localhost:8080/jsp_path/login.jsp
		http://localhost:8080/jsp_path/log/in
		
		http://localhost:8080/jsp_path/log/log/in
	 -->
	<form action="log/in">  
	账号:<input type="text" name="account"/>
	密码：<input type="password" name="password"/>
	<input type="submit"/>
	</form>
</body>
</html>