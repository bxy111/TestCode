<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="other.jsp" %> --%>
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
	<!-- include指令  静态包含 在编译期就把另一个页面的内容全部一起编译 编译后生成一个java class文件 -->
	<!-- jsp标记 -->
	<!-- include标记 ：将另一个页面的内容包含到当前页面中 
		动态包含： 编译时各自编译 然后在运行时去动态 包含另一个页面的内容
	-->
	<h2>index.jsp</h2>
	
	
	hello world
	<jsp:include page="other.jsp"></jsp:include>
	
	<br/>
	你好
	
	<!-- jsp:useBean:创建或者使用实例 -->
	<jsp:useBean id="user0" class="com.aowin.model.User" type="com.aowin.model.User" scope="session"></jsp:useBean>
	<!-- 跟属性相关的标记 -->
	<jsp:setProperty property="account" name="user0" value="zhs"/>
	<jsp:getProperty property="account" name="user0"  />
	
	
</body>
</html>