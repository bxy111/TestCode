<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="my.js"></script>
</head>
<body>
	<form action="reg">
	用户名：<input type="text" name="username" onkeyup="test(this)"/><span id="msg"></span><br/>
	密码：<input type="password" name="password"/><br/>
	家庭住址：<input type="text" name="live"/><br/>
	爱好：
	<input type="checkbox" name="hobby" value="swim"/>游泳
	<input type="checkbox" name="hobby" value="bastketball"/>篮球
	<input type="checkbox" name="hobby" value="football"/>足球
	<input type="submit"/>
	</form>
</body>
</html>