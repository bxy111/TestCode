package com.aowin.clean;

public class Test {
	//垃圾清理机制:
			//1.判断对象是否需要被回收
				//1.引用计数法:将每个对象都添加一个计数器,有一个引用指向该对象,就让该计数器+1,否则减1,时刻清理掉计数器为0的对象
					//但是会出现循环引用的情况(弊端),
				//2.可达性分析法(GcRoot),从GcRoot出发,能到达的对象是有用的,清理掉那些到达不了的对象
			//2.回收对象
				//在回收对象之前,会判断该对象是否有必要执行finalize方法,指的是,如果该对象执行过了finalize方法或者没有重写该方法,那么认为该对象,没有必要执行finalize方法
				//如果该对象重写的finalize方法并没有执行过,那么会将该对象抽离到一个队列中,然后让一个低级线程去执行这些对象的finalize
				//也就是说 finalize方法在垃圾清理之前执行,只执行一次
			//3.回收之后的内存处理
				//1.标记清理,会产生很多空间碎片
				//2.标记复制,浪费很多堆空间
				//3.标记整理,整理周期较长
	public static void main(String[] args) {
		Object1 o1=new Object1();
		Object2 o2=new Object2();
		o1.ob2=o2;
		o2.ob1=o1;
		o1=null;
		fun1();
		o2=null;
		//通知jvm回收垃圾
		System.gc();
		
	}
	public static void fun1() {
		//.....
		//func2();
		//..
		{
			int a=10;
		}
		//System.out.println(a);
	}
}
