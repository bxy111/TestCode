<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp的四个作用域 
		pageContext 页面作用域 只在当前页面有效
		request 请求作用域  一次请求
		session 会话作用域  一次会话
		application 全局作用域  服务器不关
	
		setAttribute()   getAttribute()  removeAttribute()
	-->
	
	<%
	Object o = session.getAttribute("user");
	if(o==null){
		//未登录
	%>
	<a href="login.jsp">亲，请先登录</a>
	<% 
	}else{
		//已经登录成功
	%>
	欢迎您,<%=o %><a href="login.jsp">退出</a>
	<%
	}
	%>
</body>
</html>