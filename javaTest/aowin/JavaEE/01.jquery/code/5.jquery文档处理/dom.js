$(function(){
	$("h2").click(function(){
		//将子菜单ul显示出来 show()  hide()
		// $("ul").show(2000);
		// toggle()
		$("ul").toggle(1000);
		
	})
	
	$("[value=添加子标记]").click(function(){
		//给ul添加子标记
		$("ul").append("<li>另存为</li>");
		//同before()  after() 添加兄弟标记
	})
	
	$("[value=删除标记]").click(function(){
		//删除ul中最后一个li标签  remove()
		//$("ul li:last").remove();//将匹配的元素全部删除
		$("ul li").remove();//将匹配的元素全部删除
	})
})