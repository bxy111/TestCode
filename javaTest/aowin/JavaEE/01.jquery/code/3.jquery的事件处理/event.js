//ҳ�������¼� onload  ready�¼�  ������onloadִ��
/* $(document).ready(function(){
	alert("ready...");
})

/* function init(){
	alert("onload");
} 

$(document).ready(function(){
	alert("ready2...")
})
//��д��ʽ
$(function(){
	alert("ready��д��ʽ")
})
 */

 $(function(){
	  //������������ӵ���¼� --ֻ������Ѿ����ڵı��
	 $("h2").click(function(){
		 //this����--��ǰ�������¼��ı�ǩ
		 alert($(this).text());
		 
		 //��body����ӱ�ǩ
		 var p = document.createElement("p");
		 p.innerHTML="good good study";
		 $("body")[0].appendChild(p);
		 
	 })
	 
	 //��p��ǩ��ӵ���¼�
	 /* $("p").click(function(){
		 alert($(this).text());
	 }) */
	 
	 //�¼�ί��live --��Ժ���������Ԫ��Ҳ��������¼� �����԰󶨶���¼�
	/*  $("p").live("click",function(){
		 alert($(this).text());
	 }) */
	 //�󶨶���¼� json��ʽ{������:����ֵ,������������ֵ,...��������function(){}}
	 $("p").live({
		 "mouseover":function(){//���ʱ�����¼�
			 //������ɫ���
			this.style.color="#f00";
		 },
		 "mouseout":function(){//����ƿ��¼�
			 this.style.color="#000";
		 }
	 })
	 
 })
 
