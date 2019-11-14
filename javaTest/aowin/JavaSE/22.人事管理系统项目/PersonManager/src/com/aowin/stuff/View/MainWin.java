package com.aowin.stuff.View;

import com.aowin.stuff.Dbconnection.DepartMentDAO;
import com.aowin.stuff.Dbconnection.PersonDAO;
import com.aowin.stuff.Listener.MouseTableListener;
import com.aowin.stuff.Listener.OptionButtonListener;
import com.aowin.stuff.Listener.SendButtonListener;
import com.aowin.stuff.Listener.SwitchButtonListener;
import com.aowin.stuff.Model.Department;
import com.aowin.stuff.Model.Person;
import com.aowin.stuff.Model.RecvMsgThread;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MainWin extends JFrame {
    private PersonDAO personDAO = new PersonDAO();
    private DepartMentDAO departMentDAO = new DepartMentDAO();
    private String name;        //显示用户名称
    //控制判断窗口是否显示，在切换员工管理和部门管理、问题讨论时
    private JScrollPane user;           //控制用户显示
    private JScrollPane department;     //控制部门显示
    private JScrollPane textArea;       //控制聊天室显示
    private JPanel optionButtons;       //控制增删改查按钮的显示
    private JPanel chatButton;          //控制聊天发送按钮的显示
    //增加、删除时修改表格数据
    private JTable userTable;           //设置用户表的内容
    private JTable departTable;         //设置部门表的内容
    private JTextArea area;             //设置聊天室中的内容
    public MainWin(String name) throws HeadlessException {
        this.name = name;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public  DepartMentDAO getDepartMentDAO() {
        return departMentDAO;
    }

    public static void main(String[] args) {
        MainWin admin = new MainWin("admin");
        admin.openWin();
    }

    public JPanel getOptionButtons() {
        return optionButtons;
    }

    public JPanel getChatButton() {
        return chatButton;
    }

    public JScrollPane getUser() {
        return user;
    }

    public JScrollPane getDepartment() {
        return department;
    }

    public JScrollPane getTextArea() {
        return textArea;
    }

    public JTextArea getArea() {
        return area;
    }

    public JTable getUserTable() {
        return userTable;
    }

    public JTable getDepartTable() {
        return departTable;
    }

    public void addTableData(DefaultTableModel model) {
        ArrayList<Person> people = personDAO.queryAll();
        String[] data = new String[6];
        for (Person p : people) {
            data[0] = String.valueOf(p.getId());
            data[1] = p.getName();
            data[2] = p.getSex();
            data[3] = String.valueOf(p.getAge());
            data[4] = p.getDepartment();
            data[5] = String.valueOf(p.getSalary());
            model.addRow(data);
        }
    }

    public void addDepartmentTableData(DefaultTableModel model) {
        ArrayList<Department> people = departMentDAO.queryAll();
        String[] data = new String[6];
        for (Department p : people) {
            data[0] = String.valueOf(p.getId());
            data[1] = p.getName();
            data[2] = p.getManagerName();
            model.addRow(data);
        }
    }

    public void openWin() {
        this.setLayout(new BorderLayout());

        JLabel top = new JLabel("人事管理系统");
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(top);
        this.add(topPanel, BorderLayout.NORTH);

        JPanel jPanel = new JPanel();
        this.add(jPanel, BorderLayout.CENTER);
        jPanel.setLayout(new BorderLayout());

        //左边显示内容
        JPanel left = new JPanel();
        jPanel.add(left, BorderLayout.WEST);
        left.setLayout(new GridLayout(10, 1));
        JLabel jLabel = new JLabel();
        jLabel.setText("你好," + name);
        left.add(jLabel);
        JButton person = new JButton("员工管理");
        JButton department = new JButton("部门管理");
        JButton discuss = new JButton("问题讨论");
        SwitchButtonListener switchButtonListener = new SwitchButtonListener(this);
        //切换按钮添加事件
        person.addActionListener(switchButtonListener);
        department.addActionListener(switchButtonListener);
        discuss.addActionListener(switchButtonListener);
        left.add(person);
        left.add(department);
        left.add(discuss);

        //右上显示内容
        JPanel right = new JPanel();
        right.setLayout(new BorderLayout());
        jPanel.add(right, BorderLayout.CENTER);
        JPanel tableDisplay = new JPanel();
        right.add(tableDisplay, BorderLayout.CENTER);
        //用户表格
        String[] columnNames = {"编号", "姓名", "性别", "年龄", "所在部门", "工资"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        JTable table = new JTable(model);
        JTableHeader tableHeader = table.getTableHeader();
        MouseTableListener mouseTableListener = new MouseTableListener(this);
        tableHeader.addMouseListener(mouseTableListener);
        this.userTable = table;
        //用户表格显示数据
        addTableData(model);
        JScrollPane sp = new JScrollPane(table);
        this.user = sp;
        sp.setVisible(true);
        tableDisplay.add(sp);
        //部门表格
        String[] columnNames1 = {"编号", "部门名字", "部门经理"};
        DefaultTableModel model1 = new DefaultTableModel(null, columnNames1);
        JTable table1 = new JTable(model1);
        //部门表格显示数据
        addDepartmentTableData(model1);
        JTableHeader tableHeader1 = table1.getTableHeader();
        tableHeader1.addMouseListener(mouseTableListener);
        this.departTable = table1;
        JScrollPane sp1 = new JScrollPane(table1);
        this.department = sp1;
        sp1.setVisible(false);
        tableDisplay.add(sp1);
        //聊天室框
        JTextArea jTextArea = new JTextArea(25, 30);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        this.area = jTextArea;
        jScrollPane.setVisible(false);
        this.textArea = jScrollPane;
        tableDisplay.add(jScrollPane);

        //右下显示内容
        JPanel jPanelBottom = new JPanel();
        jPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        right.add(jPanelBottom, BorderLayout.SOUTH);
        //聊天室的输入框和发送按钮
        JPanel chatroom = new JPanel();
        this.chatButton = chatroom;
        chatroom.setVisible(false);
        chatroom.setLayout(new FlowLayout(FlowLayout.CENTER));
        JTextArea jTextField = new JTextArea(3, 30);
        jTextField.setLineWrap(true);
        JScrollPane jScrollPane1 = new JScrollPane(jTextField);
        chatroom.add(jScrollPane1);
        JButton sendButton = new JButton("发送");
        chatroom.add(sendButton);
        jPanelBottom.add(chatroom);
        //建立socket连接,并绑定事件
        Socket socket = null;
        try {
            socket = new Socket("localhost", 6000);
        } catch (IOException e) {
            System.out.println("连接服务器失败，客户端退出");
            System.exit(-2);
        }
        sendButton.addActionListener(new SendButtonListener(socket, jTextField, name));
        //启动接收广播消息的线程
        new RecvMsgThread(jTextArea, socket).start();

        //增删改查等操作按钮
        JPanel jPanelButtons = new JPanel();
        this.optionButtons = jPanelButtons;
        jPanelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelButtons.setVisible(true);
        jPanelBottom.add(jPanelButtons);
        JButton add = null;
        JButton modify = null;
        JButton del = null;
        JButton impor = null;
        JButton expor = null;
        if ("admin".equals(name)) {
            //仅admin用户有权限操作
            add = new JButton("新增");
            modify = new JButton("修改");
            del = new JButton("删除");
            impor = new JButton("导入");
            expor = new JButton("导出");
        }
        JButton query = new JButton("查询");
        JButton update = new JButton("更新");
        if ("admin".equals(name)) {
            //admin用户需要添加如下按钮
            jPanelButtons.add(add);
            jPanelButtons.add(modify);
            jPanelButtons.add(del);
            jPanelButtons.add(impor);
            jPanelButtons.add(expor);
        }
        jPanelButtons.add(query);
        jPanelButtons.add(update);

        //绑定事件
        OptionButtonListener optionButtonListener = new OptionButtonListener(this);
        if ("admin".equals(name)) {
            add.addActionListener(optionButtonListener);
            modify.addActionListener(optionButtonListener);
            del.addActionListener(optionButtonListener);
            //导入和导出绑定事件
            impor.addActionListener(optionButtonListener);
            expor.addActionListener(optionButtonListener);
        }
        query.addActionListener(optionButtonListener);
        update.addActionListener(optionButtonListener);

        this.setSize(600, 550);
        this.setLocation(300, 0);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
