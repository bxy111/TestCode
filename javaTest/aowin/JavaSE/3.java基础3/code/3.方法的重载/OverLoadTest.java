public class OverLoadTest{
	public static void main(String [] args){
		//方法的重载(overload):方法名相同,参数列表不同(个数,顺序,类型),与返回值无关
		print(5);
	}
	//打印1-20
	public static  void print(){
		for(int i=0;i<20;i++){
			System.out.println(i+1);
		}
	}
	//打印1-指定位置的数
	public static  void print(int end){
		for(int i=0;i<end;i++){
			System.out.println(i+1);
		}
	}
	//打印指定范围的数
	public static  void print(int start,int end){
		for(int i=start;i<end;i++){
			System.out.println(i+1);
		}
	}
	public static  void print(String a,int b){
		
	}
	public static  void print(int a,String b){
		
	}
}