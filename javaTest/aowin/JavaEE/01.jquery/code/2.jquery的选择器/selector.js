function addCar(btn){
	//jquery中的选择器
	//1.css的选择器
	//2.兄弟选择器
	//prevAll(expr): 匹配当前元素之前的所有同辈（兄弟）元素
	//var arr = $(btn).prevAll();//获得按钮前面所有同辈元素
	var arr  =  $(btn).prevAll("div");//获得按钮前面所有同辈元素中的div
	arr.each(function(){
		//alert($(this).text());
	})
	
	//prev~siblings：匹配prev元素之后的sibling(同辈)
	var brr = $("#food~div");//匹配id属性值为food的元素之后的同辈div
	brr.each(function(){
		//alert($(this).text());
	})
	
	//3.跟索引相关的  :first   first()
	var div = $(btn).prevAll("div:first");//获得按钮前同辈div中的第一个
	var div = $(btn).prevAll("div").first();//同上 
	//alert(div.text());
	
	//:eq(index):匹配索引刚好为index的元素
	var d = $("div:eq(2)");
	//alert(d.text());
	
	//:gt(index)：匹配索引大于index的元素
	var crr=$("input:gt(1)");
	crr.each(function(){
		//获取单标记的value值  val()
		//alert($(this).val());
	})
	
	//:lt(index)：匹配索引小于index的元素
	
	//4.input的type属性值
	//获取所有复选框 :checkbox
	var chs = $(":checkbox");
	//选中的复选框
	chs = $(":checkbox:checked");
	
	chs.each(function(){
		//获取单标记的value值  val()
		//alert($(this).val());
	})
	
	
	//5.属性选择器  [属性名=属性值]
	var bb=$("[value=加入购物车]");
	$(":button");
	$("input:first")
	
	//6.获得父标记  获得子标记  children()  table.find("tr:eq(1) td:eq(3)")
	//:parent 选择器
	//parent() 筛选    匹配当前元素的父标记
	//parents()  匹配当前元素的祖先标记
	var vv=$(btn).parent();
	alert(vv.text());
	
	$(btn).parent().parent().parent();//html
	$(btn).parents("html");//html
	
	var vs = $("div:parent");//包含子元素或者文本的div
	alert(vs.length);
}





