public class OverLoadTest{
	public static void main(String [] args){
		//����������(overload):��������ͬ,�����б�ͬ(����,˳��,����),�뷵��ֵ�޹�
		print(5);
	}
	//��ӡ1-20
	public static  void print(){
		for(int i=0;i<20;i++){
			System.out.println(i+1);
		}
	}
	//��ӡ1-ָ��λ�õ���
	public static  void print(int end){
		for(int i=0;i<end;i++){
			System.out.println(i+1);
		}
	}
	//��ӡָ����Χ����
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