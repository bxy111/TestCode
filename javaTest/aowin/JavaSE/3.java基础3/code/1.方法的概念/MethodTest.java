public class MethodTest{
	public static void main(String []args){
		//����:һ�ο����ظ����õĴ���
		// ������(����),�����
		/*func1();
		System.out.println("sdadssds");
		func1();
		//�������в����ķ���ʱ,�β��б���ʵ���б������ȫ��Ӧ
		//�������ݹ����о���ʵ�θ��βθ�ֵ
		func2(20,'s');*/
		int num=func3();
		//��Ʒ���ʱҪע��,���һ������ֻ�����һ������
		//�������з���ֵʱ,���������䷵��ֵ����,����������ζ�Ҫ��֤��ǰ������һ������ֵ
		//return : 1.����ֵ 2.������ǰ����
		System.out.println(num);
		func4(num);
		
	}
	/*
		public static ����ֵ���� ������(����1,����2,����3...){
		}

	*/
	//��ӡ1-20
	public static void func1(){
		
		for(int i=0;i<20;i++){
			System.out.println(i+1);
		}
	}
	//��ӡָ����Χ
	// start end��Ϊ�β�
	public static void func2(int start,int end){
		for(int i=start;i<end;i++){
			System.out.println(i+1);
		}
	}
	//�з���ֵ�ķ���
	//��������1,5,67,823,4,-2,0�е���Сֵ
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
		System.out.println(num%2==0?"��ż��":"������");

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