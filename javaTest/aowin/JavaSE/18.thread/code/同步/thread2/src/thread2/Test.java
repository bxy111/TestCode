package thread2;

public class Test {

	public static void main(String[] args) {
		
		//采用同步synchronized解决线程安全问题
		//线程获取对象锁之后才能执行
		//同步使用有两种方式：
		//1.同步方法，在方法上增加同步关键字
		//2.同步代码块：synchronized(共享对象){},{}中的同步代码执行完毕后才会释放对象锁
		
		
		Piao piao = new Piao(20000);

		Station station = new Station();
		Proxy proxy = new Proxy();
		
		//两个线程操作同一个数据
		station.setPiao(piao);
		proxy.setPiao(piao);
		
		station.start();
		proxy.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(piao.getCount());
		
	}

}
