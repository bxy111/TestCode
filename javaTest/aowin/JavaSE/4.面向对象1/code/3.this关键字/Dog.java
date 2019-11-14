public class Dog{
	private String type;
	private double price;
	private String color;
	public String getType(){
		return type;
	}
	public void setType(String  type){
		//this是隐式的参数,代表当前方法所属的那个对象
		this.type=type;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String  color){
		this.color=color;
	}
	public double getPrice(){
		return price;	
	}
	public void setPrice(double price){
		this.price=price;
	}
}