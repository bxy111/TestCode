function showCar(){
	//��ʾ���ﳵ  ���ص�ͽ���
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
	var name = t.rows[0].cells[0].innerHTML;//��Ʒ����
	var price = t.rows[0].cells[1].innerHTML;//��Ʒ�۸�
	//��ӵ����ﳵ���
	var cartab = document.getElementById("cartab");
	var tr = cartab.insertRow(-1);
	tr.insertCell(0).innerHTML = "<input type='checkbox' name='ch' onchange='slt()'/>";
	tr.insertCell(1).innerHTML = name;
	tr.insertCell(2).innerHTML = parseInt(price);
	tr.insertCell(3).innerHTML = "<input type='button' value='ɾ��' onclick='dlt(this.parentNode.parentNode)'/>";
	num();
}
//ͳ�ƹ��ﳵ����
function num(){
	var total = document.getElementById('num');
	var rs = document.getElementById('cartab').rows;
	total.innerHTML=rs.length-1;
}
function allslt(){//ȫѡ
	var all = document.getElementById('all');
	var chs = document.getElementsByName("ch");
	for(i=0;i<chs.length;i++){
		chs[i].checked=all.checked;
	}
	priceAll();//����ͳ�Ƽ۸�
}
function slt(){//������ѡ��
	var all = document.getElementById('all');
	var chs = document.getElementsByName("ch");
	priceAll();//����ͳ�Ƽ۸�
	for(i=0;i<chs.length;i++){
		if(!chs[i].checked){
			all.checked=false;
			return;
		}
	}
	all.checked=true;
}
//�ϼƼ۸�ķ���
function priceAll(){
	// var rs = document.getElementById('cartab').rows;//��ù��ﳵ���������
	var chs = document.getElementsByName("ch");
	var sum=0;
	for(var i=0;i<chs.length;i++){
		if(chs[i].checked){//���ѡ�оͽ��ü۸���ӽ�sum������
			sum+= parseFloat(chs[i].parentNode.parentNode.cells[2].innerHTML);
		}
	}
	document.getElementById("total").innerHTML = sum;
}
function dlt(tr){
	document.getElementById('cartab').deleteRow(tr.rowIndex);
	num();//���ﳵ����
	priceAll();//���¼���۸�
}
function dltAll(){
	//�������ѡ�еĸ�ѡ�򲢰Ѷ�Ӧ����ɾ��
	var chs = document.getElementsByName("ch");
	for(var i=chs.length-1;i>=0;i--){
		if(chs[i].checked){
			dlt(chs[i].parentNode.parentNode);
		}
	}
}
function buy(){
	//��ѡ�е���Ʒ���н��� ��ʾ�۸� ɾ��ѡ��
	var total = document.getElementById("total");
	alert("������Ҫ����"+total.innerHTML+"Ԫ");//��ʾ�۸�
	dltAll();
}

