function showCar(){
	//显示购物车  隐藏点餐界面
	var car = document.getElementById("myCar");
	var main = document.getElementById("main");
	car.style.display="block";
	main.style.display="none";
}
function showMain(){
	var car = document.getElementById("myCar");
	var main = document.getElementById("main");
	car.style.display="none";
	main.style.display="block";
}
function addCar(btn){
	var t = btn.parentNode.parentNode.parentNode.parentNode;
	var name = t.rows[0].cells[0].innerHTML;//菜品名称
	var price = t.rows[0].cells[1].innerHTML;//菜品价格
	//添加到购物车表格
	var cartab = document.getElementById("cartab");
	var tr = cartab.insertRow(-1);
	tr.insertCell(0).innerHTML = "<input type='checkbox' name='ch' onchange='slt()'/>";
	tr.insertCell(1).innerHTML = name;
	tr.insertCell(2).innerHTML = parseInt(price);
	tr.insertCell(3).innerHTML = "<input type='button' value='删除' onclick='dlt(this.parentNode.parentNode)'/>";
	num();
}
//统计购物车数量
function num(){
	var total = document.getElementById('num');
	var rs = document.getElementById('cartab').rows;
	total.innerHTML=rs.length-1;
}
function allslt(){//全选
	var all = document.getElementById('all');
	var chs = document.getElementsByName("ch");
	for(i=0;i<chs.length;i++){
		chs[i].checked=all.checked;
	}
	priceAll();//重新统计价格
}
function slt(){//其他复选框
	var all = document.getElementById('all');
	var chs = document.getElementsByName("ch");
	priceAll();//重新统计价格
	for(i=0;i<chs.length;i++){
		if(!chs[i].checked){
			all.checked=false;
			return;
		}
	}
	all.checked=true;
}
//合计价格的方法
function priceAll(){
	// var rs = document.getElementById('cartab').rows;//获得购物车表格所有行
	var chs = document.getElementsByName("ch");
	var sum=0;
	for(var i=0;i<chs.length;i++){
		if(chs[i].checked){//如果选中就将该价格添加进sum变量中
			sum+= parseFloat(chs[i].parentNode.parentNode.cells[2].innerHTML);
		}
	}
	document.getElementById("total").innerHTML = sum;
}
function dlt(tr){
	document.getElementById('cartab').deleteRow(tr.rowIndex);
	num();//求购物车数量
	priceAll();//重新计算价格
}
function dltAll(){
	//获得所有选中的复选框并把对应的行删除
	var chs = document.getElementsByName("ch");
	for(var i=chs.length-1;i>=0;i--){
		if(chs[i].checked){
			dlt(chs[i].parentNode.parentNode);
		}
	}
}
function buy(){
	//将选中的商品进行结算 显示价格 删除选中
	var total = document.getElementById("total");
	alert("您共需要付款"+total.innerHTML+"元");//显示价格
	dltAll();
}

