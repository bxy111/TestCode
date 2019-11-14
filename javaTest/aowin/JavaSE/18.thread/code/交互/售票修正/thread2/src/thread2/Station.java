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
		while(true) {
			synchronized (piao) {
				if(piao.getCount()>0) {
					piao.setCount();
				}else {
					break;
				}
			}
			
		}
	}

}
