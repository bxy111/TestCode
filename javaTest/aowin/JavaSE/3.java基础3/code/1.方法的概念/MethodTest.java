public class MethodTest{
	public static void main(String []args){
		//方法:一段可以重复调用的代码
		// 先声明(定义),后调用
		/*func1();
		System.out.println("sdadssds");
		func1();
		//当调用有参数的方法时,形参列表与实参列表必须完全对应
		//参数传递过程中就是实参给形参赋值
		func2(20,'s');*/
		int num=func3();
		//设计方法时要注意,最好一个方法只能完成一个功能
		//当方法有返回值时,必须声明其返回值类型,而且无论如何都要保证当前方法有一个返回值
		//return : 1.返回值 2.结束当前方法
		System.out.println(num);
		func4(num);
		
	}
	/*
		public static 返回值类型 方法名(参数1,参数2,参数3...){
		}

	*/
	//打印1-20
	public static void func1(){
		
		for(int i=0;i<20;i++){
			System.out.println(i+1);
		}
	}
	//打印指定范围
	// start end称为形参
	public static void func2(int start,int end){
		for(int i=start;i<end;i++){
			System.out.println(i+1);
		}
	}
	//有返回值的方法
	//返回数组1,5,67,823,4,-2,0中的最小值
	public static int func3(){
		int a[]={1,5,67,823,4,-2,0};
		int min=a[0];
		for(int i=1;i<a.length;i++){
			if(min>a[i]){
				min=a[i];
			}
		}
		System.out.println(min);
		return min;
	}
	public static void func4(int num){
		System.out.println(num%2==0?"是偶数":"是奇数");

	}
	public static int func5(int [] a){
		
		int min=a[0];
		for(int i=1;i<a.length;i++){
			if(min>a[i]){
				min=a[i];
			}
		}
		System.out.println(min);
		return min;
	}
	public static double test(){
		for(int i=0;i<5;i++){
			return 1.5;
		}
		return 1;
	}	
	
}