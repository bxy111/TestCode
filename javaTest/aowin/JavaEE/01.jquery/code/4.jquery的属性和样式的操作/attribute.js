$(function(){
	//给按钮添加事件
	$("[value=添加样式]").click(function(){
		//给p标签颜色变红  css()
		//给标签添加一个样式
		//$("p").css("color","#f00");
		//$("p").css({"color":"#f00","font-size":"20px"});//给所有匹配的元素都添加
		
		$("p:first").css({"color":"#f00","font-size":"20px"});
	})
	
	//attr():如果没有该属性则添加  有则修改属性值
	$("[value=添加属性]").click(function(){
		//添加单个属性
		//$("p").attr("align","center");
		$("p").attr({"align":"center","class":"hw"});
	})
	
	$("[value=删除属性]").click(function(){
		//根据属性名删除
		$("p:eq(0)").removeAttr("align");
	})
	
	$("[value=文本内容]").click(function(){
		//text() html()      val()
		/* alert($("p:first").text());
		alert($("p:first").html()); */
		
		//$("p:first").text("你好呀<i>你好呀</i>");
		$("p:first").html("你好呀<i>你好呀</i>");
		
	})
	
	
})

