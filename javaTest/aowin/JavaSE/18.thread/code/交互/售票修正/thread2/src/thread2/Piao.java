package thread2;

public class Piao {
	
	private String from;
	private String to;
	private int count;
	
	public Piao(int count) {
		this.count = count;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getCount() {
		return count;
	}
	
	//卖出一张
	//同步方法：要执行这个方法，必须先获取对象的钥匙
	public /* synchronized */  void setCount() {
		this.count--;  //==>可分割的动作==》1.获取count   2.count-1  3.修改内存中count
	}
	
}
