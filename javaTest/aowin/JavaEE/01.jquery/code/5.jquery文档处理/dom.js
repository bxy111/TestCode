$(function(){
	$("h2").click(function(){
		//���Ӳ˵�ul��ʾ���� show()  hide()
		// $("ul").show(2000);
		// toggle()
		$("ul").toggle(1000);
		
	})
	
	$("[value=����ӱ��]").click(function(){
		//��ul����ӱ��
		$("ul").append("<li>���Ϊ</li>");
		//ͬbefore()  after() ����ֵܱ��
	})
	
	$("[value=ɾ�����]").click(function(){
		//ɾ��ul�����һ��li��ǩ  remove()
		//$("ul li:last").remove();//��ƥ���Ԫ��ȫ��ɾ��
		$("ul li").remove();//��ƥ���Ԫ��ȫ��ɾ��
	})
})