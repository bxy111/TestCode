public class Test{
	public static void main(String [] args){
		//int a=9;
		//fun1(a);
		//System.out.println(a);
		int [] a= {1,2,3,4};
		fun2(a);
		System.out.println(a);
		System.out.println(a[0]);
		//参数类型为基本数据类型,形参改变,不能修改实参的值
		//参数类型为引用数据类型,形参改变,实参也跟着变
	}
	public static void fun1(int a){
		a++;
		System.out.println(a);
	}

	public static void fun2(int a[]){
		System.out.println(a);
		a[0]=10;
		System.out.println(a[0]);
	}
}