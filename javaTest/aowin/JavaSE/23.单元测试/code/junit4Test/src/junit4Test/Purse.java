package junit4Test;

import org.junit.Test;

public class Purse {
	
	private int money;
	
	/**
	 * 		存钱
	 * 	局部变量的名字和全局变量名字可以相同，一旦相同，使用局部变量
	 * 	如果希望使用全局变量，应该：this.money
	 * @param money
	 */
	public void save(int money) {
		//money+=money;
		this.money += money;
	}
	
	/**
	 * 		取钱
	 * @param m  :
	 * @return  :
	 */
	public int fetch(int m) {
		if(this.money>=m) {
			this.money-=m;
			return m;  
		}else {
			return 0;
		}
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
