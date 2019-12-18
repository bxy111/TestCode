<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base  href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>aowin视频网站</h2>
	<c:if test="${empty user }">
		<a href="login.jsp">亲，请登录</a>
	</c:if>
	<c:if test="${not empty user }">
		欢迎您,${user.name } ,<a href="log/out">退出</a>
	</c:if><br/>
	
	<a href="vip/bxqy.jsp">冰雪奇缘2</a>
	<a href="normal/nz.jsp">哪吒</a>
</body>
</html>