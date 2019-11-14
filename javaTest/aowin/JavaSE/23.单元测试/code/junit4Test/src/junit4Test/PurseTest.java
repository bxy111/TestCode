package junit4Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/**
 * 
 * 		junit4使用注解标记测试功能
 * @author Administrator
 *
 */
public class PurseTest {
	
	private Purse p;
	
	@BeforeClass    //执行测试方法前执行（不管有几个测试方法只执行一次）
	public static void init() {
		System.out.println("init...");
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("destroy....");
	}
	
	
	@Before    //执行每一个测试方法前执行，初始化测试环境
	public void setUp() {
		System.out.println("setup/...");
		p = new Purse();
	}
	
	@After    //清理
	public void tearDown() {
		System.out.println("teardown...");
		p = null;
	}
	
	//@Ignore
	@Test   //表示下面的方法是一个测试方法
	public void testSave() {
		//Purse p = new Purse();
		p.save(100);
		//断言机制判断结果
		assertEquals(100, p.getMoney());
	}
	
	@Test
	public void testFecth() {
		//Purse p = new Purse();
		p.setMoney(100);
		int m = p.fetch(60);
		
		assertEquals(60, m);
		assertEquals(40, p.getMoney());
	}

}
