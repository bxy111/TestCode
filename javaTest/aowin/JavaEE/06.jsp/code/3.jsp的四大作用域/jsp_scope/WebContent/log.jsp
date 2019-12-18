<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- log.jsp 用来处理客户端登录的过程 -->
	<%
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	
	if("zhs".equals(account) && "123".equals(password)){
		//登录成功！
		session.setAttribute("user", account);//把用户信息保存在session中
		response.sendRedirect(request.getContextPath()+"/index.jsp");//跳转到首页
	}else{
		//登录失败
		request.setAttribute("error", "账号或密码错误!");
		request.getRequestDispatcher("/login.jsp").forward(request, response);//回到登录界面
	}
	%>
</body>
</html>