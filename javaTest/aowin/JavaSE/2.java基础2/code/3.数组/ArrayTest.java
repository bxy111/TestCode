public class ArrayTest{
	public static void main(String [] args){
		/*
			�����Ԫ�����ڴ��еĵ�ַ��������
			��Ҫ���������Ԫ����Ҫͨ��������±�����
			����λ�ô�0��ʼ
			����Ԫ�ص��������ͱ���һ��		
			��Ҫ��:���ͺͳ���
			����ĳ���һ�������,�Ͳ����޸�.������������.length����������ĳ���
			����ĵ�ַ����Ԫ�صĵ�ַ   

		*/
		//1.��̬��������
		double arr[]={1,2,2,3,4,5,6,6,6,6,1.4};
		//System.out.println(arr[11]);
		//��������
		/*for(int index=0;index<arr.length;index++){
			System.out.println(arr[index]);
		}*/
		//2.��̬��������,����֮��,Ԫ��Ϊ�����͵�Ĭ��ֵ
		char ch[]=new char[6];
		int [] a=new int[7];
		for(int i=0;i<ch.length;i++){
			System.out.print(ch[i]+",");
		}
		System.out.println();
		System.out.println("sdss"+'\u0000'+"dsdsd");
		System.out.println(arr);
		//��ά����
		double arr2[][]={{1,2,3},{4,5},{7}};
		for(int i=0;i<arr2.length;i++){
			for(int j=0;j<arr2[i].length;j++){
				System.out.print(arr2[i]);
			}
		}
		int a2[][]=new int[3][];
		//*                   
		//**
		//***
		//****
		//*****

		//     *
		//    **
		//   ***
		//  ****
		// *****
		System.out.println();
		for(int i=0;i<5;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(4-j>i){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
  

	}
}