public class Test{
	public static void main(String []args){
		/*
			��:��һ������ĳ������
			����:ĳһ������ľ�������
			��:
				����:��ʲô
				��Ϊ:�ܸ�ʲô
			ѧ����:
				����:ѧ��,����,�Ա�,�༶
				��Ϊ:˯��,�Է�,ѧϰ

		*/	
		//��������
		//���������֮�����໥������
		Student s1=new Student();
		System.out.println(s1.id+"  "+s1.name+"  "+s1.classroom);
		s1.sleep();
		s1.study();
		Student s2=new Student();
		s2.id=1002;
		s2.name="����";
		s2.classroom=3;
		System.out.println(s2.id+"  "+s2.name+"  "+s2.classroom);

	}
}