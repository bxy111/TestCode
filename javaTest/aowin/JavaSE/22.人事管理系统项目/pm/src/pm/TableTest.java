package pm;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TableTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		String[][] data = {};
		String[] colName= {"编号","名字"};
		DefaultTableModel model = new DefaultTableModel(data,colName);
		
		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		
		//双击表头事件
		JTableHeader th = table.getTableHeader();
		th.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Point point= e.getPoint(); //点击位置
					int index = table.columnAtPoint(point);  //列索引
					String name = table.getColumnName(index);  //列的名字
					System.out.println(name);
					
				}
			}
		});
		
		frame.add(pane);
		
		frame.setSize(300, 300);
		frame.setVisible(true);

	}

}
