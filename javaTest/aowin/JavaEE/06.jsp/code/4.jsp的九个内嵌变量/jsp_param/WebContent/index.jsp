<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp中的九个内嵌变量
		pageContext request  session application 
		response
		out:输出流对象 
		config:配置信息对象
		page: 跟this 指代当前页面对象
		exception:异常对象 错误页面上用来获取异常信息
	 -->
	<%
	out.print("hello");
	int a=10/0;
	%>
	<%="hello" %>
	
</body>
</html>