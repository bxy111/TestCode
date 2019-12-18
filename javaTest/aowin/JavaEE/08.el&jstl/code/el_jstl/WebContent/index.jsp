<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.aowin.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- taglib指令引入外部标记库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 函数库 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<!-- 伪造数据
	 -->
	 <%
	 	request.setAttribute("error", "账号或密码错误");
	 	session.setAttribute("error", "session error");
	 	
	 	User u=new User("zhs","123","张三");
	 	session.setAttribute("user", u);
	 	
	 	HashMap hm=new HashMap();
	 	hm.put("user", u);
	 	hm.put("hello", "world");
	 	request.setAttribute("map", hm);
	 	
	 	request.setAttribute("number", 10);
	 	
	 	String[] arr={"你好","再见","白白"};
	 	request.setAttribute("array", arr);
	 	
	 	ArrayList<User> al=new  ArrayList();
	 	al.add(new User("lisi","111","李四"));
	 	al.add(new User("www","222","问问"));
	 	al.add(u);
	 	request.setAttribute("userList", al);
	 	
	 %>
	<!-- jstl标记 的用法-->
	<!-- 1.条件选择 -->
	<c:if test="${empty user }">
		<a href="login.jsp">亲，请登录</a>
	</c:if>
	<c:if test="${not empty user }">
		欢迎你，${user.name }  <a>退出</a>
	</c:if>
	
	<hr/>
	
	<!-- c:when标签可以跟很多个   跟java中的switch case类似-->
	<c:choose>
		<c:when test="${empty user }">
			<a href="login.jsp">亲，请登录</a>
		</c:when>
		<c:when test="${not empty  user }">
			欢迎你，${user.name }  <a>退出</a>
		</c:when>
		<c:otherwise>
			都不匹配
		</c:otherwise>
	</c:choose>
	
	<hr/>
	
	<!-- 定义变量或修改变量的 标签 -->
	<c:set var="totalSalary"  value="0"></c:set>
	<!-- 循环语句  items:指定遍历的对象   var:定义循环变量   varStatus:迭代的当前状态 （状态属性如：current index count..）-->
	<table>
		<tr>	
			<th>项</th>
			<th>账号</th>
			<th>密码</th>
			<th>用户名</th>
			<th>工资</th>
		</tr>
		<c:forEach items="${userList }" var="u" varStatus="a"> 
		<tr>
			<td>${a.count }</td>
			<td>${u.account }</td>
			<td>${u.password }</td>
			<td>${u.name }</td>
			<td>1000</td>
			<%-- <td>${u.salary }</td> --%>
		</tr>
		<%-- <c:set var="totalSalary" value="${totalSalary+u.salary }"></c:set> --%>
		<c:set var="totalSalary" value="${totalSalary+1000 }"></c:set>
		</c:forEach>
		<tr>
			<td colspan="5">共有${fn:length(userList)}人 ， 合计总工资：${totalSalary }</td>
		</tr>
	</table>

	<hr/>
	

	<!-- el表达式 -->
	<!-- 1.获取作用域中的数据    根据数据名获取   从pageContext->request->session->application顺序获取数据 如果找到则不会继续查找-->
	${error}
	<!-- 指定作用域获取数据  pageScope requestScope sessionScope applicationScope -->
	${requestScope.error }
	${sessionScope.error }
	
	<hr/>
	<!-- 2.获取对象的属性  对象.属性名  get/set-->
	${sessionScope.user.account }
	${sessionScope.user.password }
	${user.name }
	
	<hr/>
	<!-- 3.获取map中的数据  根据键获取值 -->
	${map.hello }
	${map.user.name }
	
	<hr/>
	<!-- 4.运算符  运算式子放在el表达式里面
	算术运算： +  -  *  /  %
	关系运算： == ！= >  <  >=   <= 
	逻辑运算： &&  ||  !
	三目运算  ？：
	 -->
	${number+1}
	${number%2==0 }
	${number%2==0?'偶数':'奇数' }
	
	<hr/>
	<!-- 5.是否为空的判断  empty -->
	${empty sessionScope.user }
	${not empty user }
	
	<hr/>
	<!-- 6.数组操作 -->
	${array[0] }
	${array[1] }
	${array[2] }
	
	
</body>
</html>