//防止表单重复提交方式
//1.提交前判断是否为第一次提交
//2.提交后将按钮设为不可用
var flag=true;//标志变量 默认是第一次提交

function test(){
	//校验用户输入是否正确 如果错误返回false 全部正确则返回true
	var account = $("[name=account]").val();
	if(!/^\w{6,18}$/.test(account)){
		alert("账号不合法！");
		return false;//不提交表单
	}
	
	var pas = $("[name=password]");
	if(!/^\d{6,}$/.test(pas[0].value)){
		alert("密码不合法");
		return false;
	}
	
	if(pas[0].value==pas[1].value){
		return true;//提交表单
	}else{
		alert("两次密码输入不一致！")
		return false;
	}
	
}

function test2(){
	//校验用户输入是否正确 如果错误什么都不做      全部正确则手动提交表单
	var account = $("[name=account]").val();
	if(!/^\w{6,18}$/.test(account)){
		alert("账号不合法！");
		return;//不提交表单
	}
	
	var pas = $("[name=password]");
	if(!/^\d{6,}$/.test(pas[0].value)){
		alert("密码不合法");
		return;
	}
	
	if(pas[0].value==pas[1].value){
		//提交表单  : 普通按钮需要手动提交
		//$("form").submit();
		
		//防止重复提交 1
		/*if(flag){
			$("form").submit();
			flag=false;
		}else{
			alert("请勿重复提交表单！");
		}*/
		
		//防止重复提交 2
		$("form").submit();
		$("[value=注册]").attr("disabled",true);
		
	}else{
		alert("两次密码输入不一致！")
		return;
	}
}

function test3(acc){
	var account=acc.value;//获得账号
	//获得span标签用来放置对错
	var span=$("span:first");
	if(/^\w{6,18}$/.test(account)){
		span.text("√");
		span.css("color","#0f0");
		
	}else{
		span.text("×");
		span.css("color","#f00");
	}
}
