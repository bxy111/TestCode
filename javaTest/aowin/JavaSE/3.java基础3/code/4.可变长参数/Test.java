public class Test{
	public static void main(String []args){
		//可变长参数,调用函数时可以传很多参数
		//其实就是数组
		//可变长参数必须是最后一个参数
		test(1,2,3,5,6,6,6,4,43,464,3,3,43,5);
	}
	public static void test(int ... a){
		System.out.println(a);
	}
	public static void test(char s,int ... a){
		System.out.println(a);
	}
}