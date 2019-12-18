function test(){
	//获得p标记   获取内容 弹窗显示
	//js
	var p=document.getElementById("gg");//  object HTMLParagraphElement  dom对象
	//alert(p.innerHTML);//获得双标记的内容
	
	//jquery   语法： $("选择器")   css中的选择器：id  tag   class  后代 群组  *
	var p2 = $("#gg");// Object 
	//alert(p2);
	//alert(p2.innerHTML);// 错误  对象类型不同
	//text()
	//alert(p2.text());
	
	//获取多个标记元素
	var  arr =$("#gg,span");// 返回的是数组
	/* for(var i=0;i<arr.length;i++){
		arr[i].innerHTML;
	} */
	
	//each() 循环
	arr.each(function(){
		//循环体
		//隐含对象 this--当前正在遍历的对象  dom对象
		alert(this.innerHTML);
		
		//dom对象转为jquery对象  $(dom对象)
		alert($(this).text());	
	})
	
}