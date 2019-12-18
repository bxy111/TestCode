<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 三种注释 -->
	<!-- 1.html注释 -->
	<!-- 2.java注释 -->
	<!-- 3.jsp注释  -->
	<%-- jsp注释 --%>
	
	<h2>index.jsp</h2>
	int a=100;
	
	<!-- 三种java脚本形式 -->
	<!-- 1.第一种java脚本   作为service()的一部分  不能定义方法  -->
	<%
	int a=100;
	System.out.println(a);
	
	//request.getParameter("acount"); 单行注释
	%>
	
	<!-- 2.第二种java脚本   作为out.print()的参数放进去  值或者表达式-->
	<%=a %>
	
	<!-- 3.第三种java脚本  作为转换后类的一部分存在 变量是全局变量-->
	<%!
	int b=200;
	/*public void eat(){
	System.out.println("aa");
	}*/
	%>
	
	<!-- 三种脚本使用时不能嵌套 -->
	<!-- 循环打印1...10 输出给客户端 -->
	<%
	for(int i=1;i<=10;i++){
	%>
		<%=i+" " %>
	<%	
	}
	%>
	
	<hr/>
	<!-- 练习：客户端输出九九乘法口诀表  -->
	<%
	for(int i=1;i<=9;i++){
		for(int j=1;j<=i;j++){
	%>
		<%=i+"*"+j+"="+(i*j)+" &nbsp;" %>
	<%		
		}
	%>
	<br/>
	<%	
	}
	%>
	
	
</body>
</html>