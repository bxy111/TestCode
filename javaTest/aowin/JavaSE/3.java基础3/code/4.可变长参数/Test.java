public class Test{
	public static void main(String []args){
		//�ɱ䳤����,���ú���ʱ���Դ��ܶ����
		//��ʵ��������
		//�ɱ䳤�������������һ������
		test(1,2,3,5,6,6,6,4,43,464,3,3,43,5);
	}
	public static void test(int ... a){
		System.out.println(a);
	}
	public static void test(char s,int ... a){
		System.out.println(a);
	}
}