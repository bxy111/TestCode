function addCar(btn){
	//jquery�е�ѡ����
	//1.css��ѡ����
	//2.�ֵ�ѡ����
	//prevAll(expr): ƥ�䵱ǰԪ��֮ǰ������ͬ�����ֵܣ�Ԫ��
	//var arr = $(btn).prevAll();//��ð�ťǰ������ͬ��Ԫ��
	var arr  =  $(btn).prevAll("div");//��ð�ťǰ������ͬ��Ԫ���е�div
	arr.each(function(){
		//alert($(this).text());
	})
	
	//prev~siblings��ƥ��prevԪ��֮���sibling(ͬ��)
	var brr = $("#food~div");//ƥ��id����ֵΪfood��Ԫ��֮���ͬ��div
	brr.each(function(){
		//alert($(this).text());
	})
	
	//3.��������ص�  :first   first()
	var div = $(btn).prevAll("div:first");//��ð�ťǰͬ��div�еĵ�һ��
	var div = $(btn).prevAll("div").first();//ͬ�� 
	//alert(div.text());
	
	//:eq(index):ƥ�������պ�Ϊindex��Ԫ��
	var d = $("div:eq(2)");
	//alert(d.text());
	
	//:gt(index)��ƥ����������index��Ԫ��
	var crr=$("input:gt(1)");
	crr.each(function(){
		//��ȡ����ǵ�valueֵ  val()
		//alert($(this).val());
	})
	
	//:lt(index)��ƥ������С��index��Ԫ��
	
	//4.input��type����ֵ
	//��ȡ���и�ѡ�� :checkbox
	var chs = $(":checkbox");
	//ѡ�еĸ�ѡ��
	chs = $(":checkbox:checked");
	
	chs.each(function(){
		//��ȡ����ǵ�valueֵ  val()
		//alert($(this).val());
	})
	
	
	//5.����ѡ����  [������=����ֵ]
	var bb=$("[value=���빺�ﳵ]");
	$(":button");
	$("input:first")
	
	//6.��ø����  ����ӱ��  children()  table.find("tr:eq(1) td:eq(3)")
	//:parent ѡ����
	//parent() ɸѡ    ƥ�䵱ǰԪ�صĸ����
	//parents()  ƥ�䵱ǰԪ�ص����ȱ��
	var vv=$(btn).parent();
	alert(vv.text());
	
	$(btn).parent().parent().parent();//html
	$(btn).parents("html");//html
	
	var vs = $("div:parent");//������Ԫ�ػ����ı���div
	alert(vs.length);
}





