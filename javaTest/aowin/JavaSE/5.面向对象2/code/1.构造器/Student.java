public class Student{
	/*
		������(���췽��):��һ������,�÷����ķ�������������ȫһ��,����,û�з���ֵ����,��void��������
		���������������,�ڴӴ�������ʱ,���Զ������޲ι�����
		��������˹�����,ϵͳ���Ͳ������Ĭ�ϵ��޲ι�����
		������һ�㶼�Ǹ������ʼ����(����������Գ�ʼ��)
		�����������ڱ�����е���
		������ֻ���ڱ����еĹ�����֮�����,��this�ؼ���,this(�����б�),���ұ�����ڴ���ĵ�һ��
	*/
	
	
	
	private int id;
	private String name;
	public Student(){
		//this(1,"");
		System.out.println("���ǹ�����");
		return ;
	}
	public Student(int id,String name){
		this();
		System.out.println("�����вι�����");
		this.id=id;
		this.name=name;
		
	}
	public int getId(){
		return id;	
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void study(){
		System.out.println("ѧϰ");
	}
}