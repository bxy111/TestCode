function test(){
	//���p���   ��ȡ���� ������ʾ
	//js
	var p=document.getElementById("gg");//  object HTMLParagraphElement  dom����
	//alert(p.innerHTML);//���˫��ǵ�����
	
	//jquery   �﷨�� $("ѡ����")   css�е�ѡ������id  tag   class  ��� Ⱥ��  *
	var p2 = $("#gg");// Object 
	//alert(p2);
	//alert(p2.innerHTML);// ����  �������Ͳ�ͬ
	//text()
	//alert(p2.text());
	
	//��ȡ������Ԫ��
	var  arr =$("#gg,span");// ���ص�������
	/* for(var i=0;i<arr.length;i++){
		arr[i].innerHTML;
	} */
	
	//each() ѭ��
	arr.each(function(){
		//ѭ����
		//�������� this--��ǰ���ڱ����Ķ���  dom����
		alert(this.innerHTML);
		
		//dom����תΪjquery����  $(dom����)
		alert($(this).text());	
	})
	
}