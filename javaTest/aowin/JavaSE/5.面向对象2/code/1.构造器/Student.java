public class Student{
	/*
		构造器(构造方法):是一个方法,该方法的方法名与类名完全一致,并且,没有返回值类型,连void都不能有
		如果不声明构造器,在从创建对象时,会自动调用无参构造器
		如果声明了构造器,系统及就不会添加默认的无参构造器
		构造器一般都是给对象初始化的(给对象的属性初始化)
		构造器不能在别的类中调用
		构造器只能在本类中的构造器之间调用,用this关键字,this(参数列表),而且必须放在代码的第一行
	*/
	
	
	
	private int id;
	private String name;
	public Student(){
		//this(1,"");
		System.out.println("这是构造器");
		return ;
	}
	public Student(int id,String name){
		this();
		System.out.println("这是有参构造器");
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
		System.out.println("学习");
	}
}