function test(inp){
	//获得要进行校验的账号
	var username=inp.value;
	
	//ajax提交用户名
	//1.XMLHttpRequest对象
	var req=new XMLHttpRequest();
	
	//2.设置请求
	//参数1：请求方式    参数 2：url  参数3：是否为异步请求
//	req.open("get","AjaxServlet?username="+username,true);
	
	req.open("post","AjaxServlet",true);
	req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	
	//3.发送请求
//	req.send(null);
	req.send("username="+username);
	
	//4.接收服务器响应的内容(确保服务器端响应成功后再去回去响应的 内容)
	//var text=req.responseText;
	req.onreadystatechange=function(){
		//判断状态是否为4
		if(req.readyState==4){//交互完成
			if(req.status==200){
				var str=req.responseText;//响应的文本内容
				//alert(str);
				/*var sp = document.getElementById("msg");//获得 提示的span标记
				if(str==0){//不重复
					sp.innerHTML="账号可用";
				}else{
					sp.innerHTML="账号已被占用";
				}*/
				//alert(typeof(str));//接收到的是json格式的 字符串
				//将json格式字符串转为json对象  eval()
				/*alert(str);
				var o = eval("("+str+")");
				alert(o);
				alert(o.account+"-"+o.password+"-"+o.name);*/
				
				var arr = eval("("+str+")");
				//获得购物车的 表格
				for(var i=0;i<arr.length;i++){
					alert(arr[i].name);
				}
				
			}
		}
	}
	
	
}