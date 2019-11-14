public class SwitchTest{
	public static void main(String [] args){
		/*
			switch(变量){
				case 值1 :
					执行的语句;
					break;//退出当前的switch语句
				case 值2 :
					执行的语句;
					break;
				...
				default :
					执行的语句;
					break;
			}

		*/
		short num=10;
		//switch语句中,变量的类型必须小于等于int类型
		//字符串,枚举也可以
		String s="111";
		switch(s){
			case "sd":
				System.out.println("这是1");
				 break;
			case "111":
				System.out.println("这是10");
				// break;
			case "fds":
				System.out.println("这是100");
				 break;
			default:
				System.out.println("没有");
		}
	}

}