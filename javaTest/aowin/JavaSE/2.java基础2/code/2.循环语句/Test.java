public class Test{
	public static void main(String [] args){
		/*
			while(ѭ��������){
				��������ʱ,ִ�еĴ���
			}

			do{
				��������ʱ,ִ�еĴ���
			}while(ѭ��������);
			
			for(���ʽ1;���ʽ2;���ʽ3){
				����4
			}
			���ʽ1һ�㶼�Ǳ����ĳ�ʼ��
			���ʽ2��ѭ��ִ�е�����
			���ʽ3һ�㶼�Ǳ��������������Լ�
			12432432432432432
			

			break:������ǰѭ��
			continue:��������ѭ��,�����´�ѭ��

		*/
		boolean result=false;
		while(result){
			System.out.println("sss");
		}
		do{
			System.out.println("sss");
		}while(result);	
		System.out.println("qqq");
		for(int i=0;i<10;i++){
			if(i==5){
				continue;
			}
			System.out.println(i);
			
		}
		for(int i=0;i<10;i++){

			for(int j=0;j<10;j++){
				if(i==5){
					break;
				}
				System.out.println(i+" "+j);
			}
		}
		
	}
}