package thread2;

public class Dead {

	public static void main(String[] args) {
		Object obj1 = new Object();  //有一个钥匙
		Object obj2 = new Object();  //有一个钥匙
		
		//同步可能造成死锁
		//两个线程使用相同的多个资源
		//造成问题：
		//t1获取obj1,t2获取obj2，但是都需要对方的资源才能执行完毕==》互相等待
		T1 t1 = new T1(obj1,obj2);
		T2 t2 = new T2(obj1,obj2);
		
		t1.start();
		t2.start();

	}

}

class T1 extends Thread{
	private Object obj1;
	private Object obj2;
	
	public T1(Object obj1,Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj1) {
			System.out.println("t1获取obj1,执行任务");
			synchronized (obj2) {
				System.out.println("t1又获取obj2,执行其它任务");
			}
		}
		
		
	}
}
class T2 extends Thread{
	private Object obj1;
	private Object obj2;
	
	public T2(Object obj1,Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj2) {
			System.out.println("t2获取obj2,执行任务");
			synchronized (obj1) {
				System.out.println("t2又获取obj1,执行其它任务");
			}
		}
	}
}

