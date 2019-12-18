package servlet_life;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//生命周期   由web容器管理
//创建阶段:在客户端第一次访问servlet的url时 由web容器会创建一个servlet对象 调用init()进行初始化
//运行阶段：只要有客户端发送请求 就通过该对象来调用对应的方法来处理请求
//销毁阶段：当服务器关闭时servlet对象就会被销毁 前会调用destroy()  或者工程被移除时也会销毁servlet对象
public class LifeServlet extends HttpServlet{
	
	public LifeServlet() {
		super();
		System.out.println("create....");
	}

	@Override
	public void destroy() {
		System.out.println("destroy....");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get....");
	}
}
