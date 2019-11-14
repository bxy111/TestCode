package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//通过鼠标事件适配器类避免实现很多方法，只需要重写需要的方法
public class MyMouseAdapter extends MouseAdapter{
	
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击了TextField");
	}

}
