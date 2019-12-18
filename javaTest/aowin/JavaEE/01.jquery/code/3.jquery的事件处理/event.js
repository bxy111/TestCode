//页面载入事件 onload  ready事件  优先于onload执行
/* $(document).ready(function(){
	alert("ready...");
})

/* function init(){
	alert("onload");
} 

$(document).ready(function(){
	alert("ready2...")
})
//简写形式
$(function(){
	alert("ready简写形式")
})
 */

 $(function(){
	  //给二级标题添加点击事件 --只针对于已经存在的标记
	 $("h2").click(function(){
		 //this对象--当前发生该事件的标签
		 alert($(this).text());
		 
		 //给body添加子标签
		 var p = document.createElement("p");
		 p.innerHTML="good good study";
		 $("body")[0].appendChild(p);
		 
	 })
	 
	 //给p标签添加点击事件
	 /* $("p").click(function(){
		 alert($(this).text());
	 }) */
	 
	 //事件委托live --针对后来产生的元素也可以添加事件 还可以绑定多个事件
	/*  $("p").live("click",function(){
		 alert($(this).text());
	 }) */
	 //绑定多个事件 json格式{属性名:属性值,属性名：属性值,...方法名：function(){}}
	 $("p").live({
		 "mouseover":function(){//鼠标时悬浮事件
			 //字体颜色变红
			this.style.color="#f00";
		 },
		 "mouseout":function(){//鼠标移开事件
			 this.style.color="#000";
		 }
	 })
	 
 })
 
