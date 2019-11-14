public class Test{
	public static void main(String [] args){
		/*
			while(循环的条件){
				条件满足时,执行的代码
			}

			do{
				条件满足时,执行的代码
			}while(循环的条件);
			
			for(表达式1;表达式2;表达式3){
				代码4
			}
			表达式1一般都是变量的初始化
			表达式2是循环执行的条件
			表达式3一般都是变量的自增或者自减
			12432432432432432
			

			break:结束当前循环
			continue:结束本次循环,继续下次循环

		*/
		boolean result=false;
		while(result){
			System.out.println("sss");
		}
		do{
			System.out.println("sss");
		}while(result);	
		System.out.println("qqq");
		for(int i=0;i<10;i++){
			if(i==5){
				continue;
			}
			System.out.println(i);
			
		}
		for(int i=0;i<10;i++){

			for(int j=0;j<10;j++){
				if(i==5){
					break;
				}
				System.out.println(i+" "+j);
			}
		}
		
	}
}