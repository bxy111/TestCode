package thread2;

public class Proxy extends Thread{
	
	private Piao piao;

	public void setPiao(Piao piao) {
		this.piao = piao;
	}
	
	@Override
	public  void run() {	
		
		for(int i=0;i<10000;i++) {
			synchronized (piao) {
				piao.setCount();
			}
			
		}		
	}

}
