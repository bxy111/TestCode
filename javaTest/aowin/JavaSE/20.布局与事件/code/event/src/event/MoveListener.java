package event;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;

public class MoveListener extends MouseAdapter /* implements ActionListener */{
	
	private JList<String> leftList;
	private JList<String> rightList;
	private Vector<String> leftData;
	private Vector<String> rightData;
	
	public MoveListener(JList<String> leftList,JList<String> rightList,Vector<String> leftData,Vector<String> rightData) {
		this.leftList = leftList;
		this.rightList = rightList;
		this.leftData = leftData;
		this.rightData = rightData;
	}
	
	//点击事件
	public void mouseClicked(MouseEvent e) {
		//区分点击了哪一个按钮
		JButton but = (JButton) e.getSource();
		String text = but.getText();
		if(">>".equals(text)) {
			//将左边的选中项移动到右边
			int index = leftList.getSelectedIndex();
			if(index != -1) {
				//确定有选中项的时候才需要移动
				String s = leftData.get(index);
				leftData.remove(index);
				rightData.add(s);
				
				leftList.setListData(leftData);
				rightList.setListData(rightData);
			}
			
		}else if("<<".equals(text)) {
			int index = rightList.getSelectedIndex();
			if(index != -1) {
				String s = rightData.get(index);
				rightData.remove(index);
				leftData.add(s);
				
				leftList.setListData(leftData);
				rightList.setListData(rightData);
				
			}
		}
	}
}
