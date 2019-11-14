package zhu;

public class Father {
	
	public void eat() {
		@SuppressWarnings("unused")
		int  m = 0;
	}
	
	@Deprecated  //表示下面的方法过时了
	public void zhongdi() {}

}

class Child  extends Father{
	
	@Override   //这个注解用来标记下面的方法是一个重写的方法
	public void eat() {
		// TODO Auto-generated method stub
		super.eat();
	}
	
}