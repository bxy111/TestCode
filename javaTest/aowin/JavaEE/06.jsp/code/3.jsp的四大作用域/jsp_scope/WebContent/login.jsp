<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="log.jsp">
	账号:<input type="text" name="account"/>
	密码:<input type="password" name="password"/>
	<input type="submit"/>
	<span style="color:red"><%=request.getAttribute("error")==null?"":request.getAttribute("error") %></span>
	</form>
</body>
</html>