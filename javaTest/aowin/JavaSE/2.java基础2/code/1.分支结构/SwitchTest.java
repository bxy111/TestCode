public class SwitchTest{
	public static void main(String [] args){
		/*
			switch(����){
				case ֵ1 :
					ִ�е����;
					break;//�˳���ǰ��switch���
				case ֵ2 :
					ִ�е����;
					break;
				...
				default :
					ִ�е����;
					break;
			}

		*/
		short num=10;
		//switch�����,���������ͱ���С�ڵ���int����
		//�ַ���,ö��Ҳ����
		String s="111";
		switch(s){
			case "sd":
				System.out.println("����1");
				 break;
			case "111":
				System.out.println("����10");
				// break;
			case "fds":
				System.out.println("����100");
				 break;
			default:
				System.out.println("û��");
		}
	}

}