public class Car{
	private String brand;
	private String color;
	 static double price=1.8;
	/*
		static:��̬��
			��̬�����ݹ�������,������޹�
			��̬����ʱ���и���������
			��̬����ʹ��ʱ,���ʹ������.������(������)������
			���η���ʱ,��ǰ��̬������ֻ��ʹ�þ�̬����,���Ҳ���ʹ��this
			
*/
	public Car(){
	}
	public Car(String brand,String color){
		this.brand= brand;
		this.color=color;
	}
	public String getBrand(){
		return brand;
	}
	public void setBrand(String brand){
		this.brand=brand;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public static  void drive(){
		System.out.println("�������İ�����Ħ��,����Զ������³�"+this.color);
	}
	public void didi(){
		drive();
	}
}
