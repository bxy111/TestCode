package junit3Test;

import junit.framework.TestCase;

/**
 * 			junit通过继承TestCase定义测试用例
 * @author Administrator
 *
 */
public class PurseTest extends TestCase{
	private Purse p;
	
	
	/**
	 * 		用来初始化测试环境
	 * 		执行每一个测试方法之前都会执行
	 */
	public void setUp() {
		p = new Purse();
		System.out.println("setup...");
	}	
	
	/**
	 * 
	 * 	清理测试数据
	 * 	执行完每一个测试方法之后都会调用
	 */
	public void tearDown() {
		p = null;
		System.out.println("teardown...");
	}
	
	/**
	 * 	测试方法：public void 	testXXX(){}
	 * 	测试钱包存钱的方法
	 */
	  public void testSave() {
		  System.out.println("testSave,......");
		  //Purse p = new Purse();  //初始钱数0
		  p.save(100); //存了100
		  //通过断言机制判断结果
		  assertEquals(100, p.getMoney());   //判断期望值和实际值是否相等
	  }
	  
	  public void testFetch() {
		  System.out.println("testFecth....");
		  //Purse p = new Purse();
		  p.setMoney(100);  //假设钱包中有100
		  int m = p.fetch(200);  //想取200
		  
		  assertEquals(0, m);  //取到的
		 // assertTrue(p.getMoney()>=0);  //钱包中的余额应该是>=0
		  assertEquals(100, p.getMoney());
	  }

}
