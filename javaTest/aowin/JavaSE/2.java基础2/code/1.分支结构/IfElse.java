public class IfElse{
	/*
		if(判断条件){  条件的结果必须为布尔类型
			
			条件满足时执行的代码
		}else{
			条件不满足时执行的代码
		}
		其他的变形
		if(){
		}else if(){
		}else if(){
		}....{
		}else{
		}
		
		if(){
		}

	
	*/
	public static void main(String [] args){
		int num=3;
		if(num%2==0){
			System.out.println(num+"是偶数");
		}else{
			System.out.println(num+"是奇数");
		}
		
	}
}