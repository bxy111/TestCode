public class ArrayTest{
	public static void main(String [] args){
		/*
			数组的元素在内存中的地址是连续的
			想要访问数组的元素需要通过数组的下标索引
			索引位置从0开始
			数组元素的数据类型必须一致		
			两要素:类型和长度
			数组的长度一旦定义好,就不会修改.可以用数组名.length来访问数组的长度
			数组的地址是首元素的地址   

		*/
		//1.静态定义数组
		double arr[]={1,2,2,3,4,5,6,6,6,6,1.4};
		//System.out.println(arr[11]);
		//遍历数组
		/*for(int index=0;index<arr.length;index++){
			System.out.println(arr[index]);
		}*/
		//2.动态定义数组,定义之后,元素为该类型的默认值
		char ch[]=new char[6];
		int [] a=new int[7];
		for(int i=0;i<ch.length;i++){
			System.out.print(ch[i]+",");
		}
		System.out.println();
		System.out.println("sdss"+'\u0000'+"dsdsd");
		System.out.println(arr);
		//二维数组
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