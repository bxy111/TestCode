$(function(){
	//����ť����¼�
	$("[value=�����ʽ]").click(function(){
		//��p��ǩ��ɫ���  css()
		//����ǩ���һ����ʽ
		//$("p").css("color","#f00");
		//$("p").css({"color":"#f00","font-size":"20px"});//������ƥ���Ԫ�ض����
		
		$("p:first").css({"color":"#f00","font-size":"20px"});
	})
	
	//attr():���û�и����������  �����޸�����ֵ
	$("[value=�������]").click(function(){
		//��ӵ�������
		//$("p").attr("align","center");
		$("p").attr({"align":"center","class":"hw"});
	})
	
	$("[value=ɾ������]").click(function(){
		//����������ɾ��
		$("p:eq(0)").removeAttr("align");
	})
	
	$("[value=�ı�����]").click(function(){
		//text() html()      val()
		/* alert($("p:first").text());
		alert($("p:first").html()); */
		
		//$("p:first").text("���ѽ<i>���ѽ</i>");
		$("p:first").html("���ѽ<i>���ѽ</i>");
		
	})
	
	
})

