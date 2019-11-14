package thread2;

public class Proxy extends Thread{
	
	private Piao piao;

	public void setPiao(Piao piao) {
		this.piao = piao;
	}
	
	@Override
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
