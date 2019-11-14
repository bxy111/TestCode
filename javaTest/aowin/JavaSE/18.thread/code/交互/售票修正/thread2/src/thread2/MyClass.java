package thread2;

//假设多个线程同时使用一个MyClass的对象，只有一个钥匙
//一个线程调用非同步方法，其它线程可以调用其它方法
//一个线程调用同步方法（这个线程获取钥匙，其它线程不能再次获取钥匙），其它线程可以调用非同步方法，但是不能调用其它同步方法
public class MyClass {
	
	public void f1() {
		System.out.println("f1");
	}
	
	public synchronized void f2() {
		System.out.println("f2");
	}
	public synchronized void f3() {
		System.out.println("f2");
	}

}
