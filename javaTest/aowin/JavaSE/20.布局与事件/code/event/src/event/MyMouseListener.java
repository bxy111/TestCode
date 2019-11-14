package event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener{

	//点击事件==》分成单击   双击
	public void mouseClicked(MouseEvent e) {
//		System.out.println("mouseClicked");
//		
//		int count = e.getClickCount();
//		if(count==2) {
//			System.out.println("双击。。。。");
//		}
		
		int button = e.getButton();
		if(button == MouseEvent.BUTTON1) {  //左键
			System.out.println("button1");
		}
		if(button == MouseEvent.BUTTON2) {  //滚轮
			System.out.println("button2");
		}
		if(button == MouseEvent.BUTTON3) {  //右键
			System.out.println("button3");
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//鼠标移动到组件上面
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	//鼠标移走
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
		
	}

}
