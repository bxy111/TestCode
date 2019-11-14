package practice1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());

        JLabel jLabel = new JLabel("人事管理系统");
        JPanel jPanel = new JPanel();
        jPanel.add(jLabel);
        jFrame.add(jPanel);

        String[] columns = {"工号", "名字", "性别", "部门", "工资"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columns);
        JTable jTable = new JTable(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jFrame.add(jScrollPane);

        JButton addButton = new JButton("添加");
        JButton delButton = new JButton("删除");
        JButton modifyButton = new JButton("修改");
        JButton updateButton = new JButton("更新");
        JButton queryButton = new JButton("查询");
        jFrame.add(addButton);
        jFrame.add(delButton);
        jFrame.add(modifyButton);
        jFrame.add(updateButton);
        jFrame.add(queryButton);

        JMenu file = new JMenu("File");
        file.add(new JMenuItem("增加"));
        file.add(new JMenuItem("删除"));
        file.add(new JMenuItem("查询"));
        file.addSeparator();
        file.add(new JMenuItem("退出"));
        file.add(new JMenuItem("导入"));
        file.add(new JMenuItem("导出"));
        JMenu help = new JMenu("Help");
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(file);
        jMenuBar.add(help);
        jFrame.setJMenuBar(jMenuBar);

        jFrame.setSize(500, 600);
        jFrame.setLocation(200, 0);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
