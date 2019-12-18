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
<script type="text/javascript" src="jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	function test(){
		//jquery
		//参数1:url  参数2：请求参数 （可选）   参数3：回调函数     参数4：响应的数据格式(text,json,xml,html)
		/* $.get("AjaxServlet",{"account":"zhs","password":"123"},function(data){
			alert(data);
			alert(data.name+"-"+data.account);
		},"json") */
		
		/* $.post("AjaxServlet",{"account":"zhs","password":"123"},function(data){
			alert(data);
			alert(data.name+"-"+data.account);
		},"json") */
		
		//ajax()
		/* $.ajax({
			"url":"AjaxServlet",//请求的url
			"data":{"account":"zhs","password":"123"},//请求参数
			"type":"get",//请求方式
			"dataType":"json",//响应数据格式
			"Async":true,//是否为异步请求
			"success":function(data){
				alert(data.name);
			}
		}) */
		
		//load() 加载服务器数据放到指定的标签中
		//$("p").load("second.jsp");
		//$("p").load("second.jsp span");
		//url,请求参数  ，回调函数
		$("p").load("AjaxServlet",{"account":"zhs","password":"123"},function(responseText,statusText,xhr){
			/* alert(responseText)
			alert(statusText)
			alert(xhr) */
			eval("("+responseText+")")
		})
		
		
		
	}
</script>
</head>
<body>
	<input type="button" value="jquery" onclick="test()"/>
	
	<p></p>
</body>
</html>