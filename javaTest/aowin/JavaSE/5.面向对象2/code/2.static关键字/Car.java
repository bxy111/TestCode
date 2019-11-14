public class Car{
	private String brand;
	private String color;
	 static double price=1.8;
	/*
		static:静态的
			静态的数据归类所有,与对象无关
			静态数据时所有该类对象共享的
			静态数据使用时,最好使用类名.变量名(方法名)来调用
			修饰方法时,当前静态方法中只能使用静态数据,而且不能使用this
			
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
		System.out.println("骑上我心爱的新摩托,他永远都不会堵车"+this.color);
	}
	public void didi(){
		drive();
	}
}
