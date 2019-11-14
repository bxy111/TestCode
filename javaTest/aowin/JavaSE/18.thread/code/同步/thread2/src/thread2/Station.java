package thread2;

/**
 * 		火车站卖票
 * @author Administrator
 *
 */
public class Station extends Thread{
	
	private Piao piao;

	public void setPiao(Piao piao) {
		this.piao = piao;
	}
	
	public  void run() {
		for(int i=0;i<10000;i++) {
			synchronized (piao) {
				piao.setCount();
			}
		}
	}

}
