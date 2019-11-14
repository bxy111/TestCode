package com.aowin.stuff.Listener;

import com.aowin.stuff.Model.Department;
import com.aowin.stuff.Model.Person;
import com.aowin.stuff.View.DepartmentWin;
import com.aowin.stuff.View.MainWin;
import com.aowin.stuff.View.OptionWin;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OptionButtonListener implements ActionListener {
    private MainWin mainWin;
    private OptionWin optionWin;
    private DepartmentWin departmentWin;

    public OptionButtonListener(MainWin window) {
        this.mainWin = window;
        this.optionWin = new OptionWin(window, this);
        this.departmentWin = new DepartmentWin(window, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "查询":
            case "新增": {
                mainWin.setEnabled(false);
                optionWin.setTitle(actionCommand);
                departmentWin.setTitle(actionCommand);
                if (mainWin.getUser().isVisible()) {
                    optionWin.clearData();
                    optionWin.openWinWithoutID();
                } else if (mainWin.getDepartment().isVisible()) {
                    departmentWin.clearData();
                    departmentWin.openWinWithoutID();
                }
                break;
            }
            case "修改": {
                optionWin.setTitle(actionCommand);
                departmentWin.setTitle(actionCommand);
                if (mainWin.getUser().isVisible()) {
                    JTable userTable = mainWin.getUserTable();
                    int selectedRow = userTable.getSelectedRow();
                    if (selectedRow == -1) {
                        //未选中行,提示错误
                        JOptionPane.showMessageDialog(mainWin, "请选择一行数据", "提示", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    TableModel model = userTable.getModel();
                    int columnCount = model.getColumnCount();
                    String[] data = new String[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        data[i] = (String) model.getValueAt(selectedRow, i);
                    }
                    optionWin.setData(data);
                    optionWin.openWinWithID();
                    mainWin.setEnabled(false);
                } else if (mainWin.getDepartment().isVisible()) {
                    JTable userTable = mainWin.getDepartTable();
                    int selectedRow = userTable.getSelectedRow();
                    if (selectedRow == -1) {
                        //未选中行,提示错误
                        JOptionPane.showMessageDialog(mainWin, "请选择一行数据", "提示", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    TableModel model = userTable.getModel();
                    int columnCount = model.getColumnCount();
                    String[] data = new String[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        data[i] = (String) model.getValueAt(selectedRow, i);
                    }
                    departmentWin.setData(data);
                    departmentWin.openWinWithID();
                    mainWin.setEnabled(false);
                }
                break;
            }
            case "删除": {
                optionWin.setTitle(actionCommand);
                departmentWin.setTitle(actionCommand);
                if (mainWin.getUser().isVisible()) {
                    JTable userTable = mainWin.getUserTable();
                    int selectedRow = userTable.getSelectedRow();
                    if (selectedRow == -1) {
                        //未选中行,提示错误
                        JOptionPane.showMessageDialog(mainWin, "请选择一行数据", "提示", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    int option = JOptionPane.showConfirmDialog(mainWin, "确认删除？", "确认操作", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        //删除表格中和数据库中的数据，根据所选行的id去删除
                        TableModel model = userTable.getModel();
                        String id = (String) model.getValueAt(selectedRow, 0);
                        mainWin.getPersonDAO().delDataById(Integer.valueOf(id));
                        updateData();
                    }
                } else if (mainWin.getDepartment().isVisible()) {
                    JTable userTable = mainWin.getDepartTable();
                    int selectedRow = userTable.getSelectedRow();
                    if (selectedRow == -1) {
                        //未选中行,提示错误
                        JOptionPane.showMessageDialog(mainWin, "请选择一行数据", "提示", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    int option = JOptionPane.showConfirmDialog(mainWin, "确认删除？", "确认操作", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        //删除表格中和数据库中的数据，根据所选行的id去删除
                        TableModel model = userTable.getModel();
                        String id = (String) model.getValueAt(selectedRow, 0);
                        mainWin.getDepartMentDAO().delDataById(Integer.valueOf(id));
                        updateData();
                    }
                }
                break;
            }
            case "更新": {
                updateData();
                break;
            }
            case "导出": {
                if (mainWin.getUser().isVisible()) {
                    JTable userTable = mainWin.getUserTable();
                    int[] selectedRows = userTable.getSelectedRows();
                    if (selectedRows.length == 0) {
                        JOptionPane.showMessageDialog(mainWin, "请选择需要导出的数据", "提示", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FileFilter() {
                        public boolean accept(File f) {
                            if (f.isDirectory() || f.getName().endsWith(".xml")) {
                                return true;
                            }
                            return false;
                        }

                        public String getDescription() {
                            return null;
                        }
                    });
                    int c = chooser.showSaveDialog(mainWin);
                    if (c == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                    File file = chooser.getSelectedFile();
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            break;
                        }
                    }
                    TableModel model = userTable.getModel();
                    int columnCount = model.getColumnCount();
                    String[][] data = new String[selectedRows.length][columnCount];
                    for (int j = 0; j < selectedRows.length; j++) {
                        for (int i = 0; i < columnCount; i++) {
                            data[j][i] = (String) model.getValueAt(selectedRows[j], i);
                        }
                    }
                    writePersonToXML(data, file);
                    JOptionPane.showMessageDialog(mainWin, "导出完成", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else if (mainWin.getDepartment().isVisible()) {
                    JTable userTable = mainWin.getDepartTable();
                    int[] selectedRows = userTable.getSelectedRows();
                    if (selectedRows.length == 0) {
                        JOptionPane.showMessageDialog(mainWin, "请选择需要导出的数据", "提示", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FileFilter() {
                        public boolean accept(File f) {
                            if (f.isDirectory() || f.getName().endsWith(".xml")) {
                                return true;
                            }
                            return false;
                        }

                        public String getDescription() {
                            return null;
                        }
                    });
                    int c = chooser.showSaveDialog(mainWin);
                    if (c == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                    File file = chooser.getSelectedFile();
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            break;
                        }
                    }
                    TableModel model = userTable.getModel();
                    int columnCount = model.getColumnCount();
                    String[][] data = new String[selectedRows.length][columnCount];
                    for (int j = 0; j < selectedRows.length; j++) {
                        for (int i = 0; i < columnCount; i++) {
                            data[j][i] = (String) model.getValueAt(selectedRows[j], i);
                        }
                    }
                    writeDepartmentToXML(data, file);
                    JOptionPane.showMessageDialog(mainWin, "导出完成", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            case "导入": {
                if (mainWin.getUser().isVisible()) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FileFilter() {
                        public boolean accept(File f) {
                            if (f.isDirectory() || f.getName().endsWith(".xml")) {
                                return true;
                            }
                            return false;
                        }

                        public String getDescription() {
                            return null;
                        }
                    });
                    int c = chooser.showOpenDialog(mainWin);
                    if (c == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                    File file = chooser.getSelectedFile();
                    writePersonXMLToDB(file);
                    JOptionPane.showMessageDialog(mainWin, "导入数据完成", "提示", JOptionPane.INFORMATION_MESSAGE);
                } else if (mainWin.getDepartment().isVisible()) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FileFilter() {
                        public boolean accept(File f) {
                            if (f.isDirectory() || f.getName().endsWith(".xml")) {
                                return true;
                            }
                            return false;
                        }

                        public String getDescription() {
                            return null;
                        }
                    });
                    int c = chooser.showOpenDialog(mainWin);
                    if (c == JFileChooser.CANCEL_OPTION) {
                        break;
                    }
                    File file = chooser.getSelectedFile();
                    writeDepartmentXMLToDB(file);
                    JOptionPane.showMessageDialog(mainWin, "导入数据完成", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
        }
    }

    private void writeDepartmentXMLToDB(File file) {
        SAXReader saxReader = new SAXReader();
        Document read = null;
        ArrayList<Department> ps = new ArrayList<>();
        try {
            read = saxReader.read(file);
            Element rootElement = read.getRootElement();
            Iterator<Element> elementIterator = rootElement.elementIterator();
            outWhile:
            while (elementIterator.hasNext()) {
                Department p = new Department();
                Element next = elementIterator.next();
                List<Element> elements = next.elements();
                for (Element e : elements) {
                    if ("id".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("id is null");
                            continue outWhile;
                        }
                        int id = 0;
                        try {
                            id = Integer.parseInt(e.getText());
                            if (id <= 0) {
                                System.out.println("id num is invalid");
                                continue outWhile;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("id format is invalid");
                            continue outWhile;
                        }
                        p.setId(id);
                    } else if ("name".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("name is null");
                            continue outWhile;
                        }
                        p.setName(e.getText());
                    } else if ("manager".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("sex is null");
                            continue outWhile;
                        }
                        p.setManagerName(e.getText());
                    }
                }
                ps.add(p);
            }
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        mainWin.getDepartMentDAO().insertData(ps);
    }

    private void writePersonXMLToDB(File file) {
        SAXReader saxReader = new SAXReader();
        Document read = null;
        ArrayList<Person> ps = new ArrayList<>();
        try {
            read = saxReader.read(file);
            Element rootElement = read.getRootElement();
            Iterator<Element> elementIterator = rootElement.elementIterator();
            outWhile:
            while (elementIterator.hasNext()) {
                Person p = new Person();
                Element next = elementIterator.next();
                List<Element> elements = next.elements();
                for (Element e : elements) {
                    if ("id".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("id is null");
                            continue outWhile;
                        }
                        int id = 0;
                        try {
                            id = Integer.parseInt(e.getText());
                            if (id <= 0) {
                                System.out.println("id num is invalid");
                                continue outWhile;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("id format is invalid");
                            continue outWhile;
                        }
                        p.setId(id);
                    } else if ("name".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("name is null");
                            continue outWhile;
                        }
                        p.setName(e.getText());
                    } else if ("sex".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("sex is null");
                            continue outWhile;
                        }
                        String text = e.getText();
                        if (!"男".equals(text) && !"女".equals(text)) {
                            System.out.println("sex value is invalid, sex=" + text);
                            continue outWhile;
                        }
                        p.setSex(text);
                    } else if ("age".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("age is null");
                            continue outWhile;
                        }
                        int age = 0;
                        try {
                            age = Integer.parseInt(e.getText());
                            if (age <= 18 || age >= 65) {
                                System.out.println("age is invalid");
                                continue outWhile;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("age format is invalid");
                            continue outWhile;
                        }
                        p.setAge(age);
                    } else if ("department".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("department is null");
                            continue outWhile;
                        }
                        p.setDepartment(e.getText());
                    } else if ("salary".equals(e.getName())) {
                        if (e.getText() == null) {
                            System.out.println("salary is null");
                            continue outWhile;
                        }
                        int salary = 0;
                        try {
                            salary = Integer.parseInt(e.getText());
                            if (salary <= 1000 || salary >= 100000) {
                                System.out.println("salary is invalid");
                                continue outWhile;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("salary format is invalid");
                            continue outWhile;
                        }
                        p.setSalary(salary);
                    }
                }
                ps.add(p);
            }
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        mainWin.getPersonDAO().insertData(ps);
    }

    private void writeDepartmentToXML(String[][] data, File file) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("departments");

        for (int i = 0; i < data.length; i++) {
            Element user = root.addElement("department");
            Element id = user.addElement("id");
            id.setText(data[i][0]);
            Element name = user.addElement("name");
            name.setText(data[i][1]);
            Element sex = user.addElement("manager");
            sex.setText(data[i][2]);
        }

        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setIndent(true);
        prettyPrint.setIndentSize(4);
        XMLWriter xmlWriter = null;
        try {
            xmlWriter = new XMLWriter(new FileWriter(file), prettyPrint);
            xmlWriter.write(document);
            xmlWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void writePersonToXML(String[][] data, File file) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("users");

        for (int i = 0; i < data.length; i++) {
            Element user = root.addElement("user");
            Element id = user.addElement("id");
            id.setText(data[i][0]);
            Element name = user.addElement("name");
            name.setText(data[i][1]);
            Element sex = user.addElement("sex");
            sex.setText(data[i][2]);
            Element age = user.addElement("age");
            age.setText(String.valueOf(data[i][3]));
            Element department = user.addElement("department");
            department.setText(String.valueOf(data[i][4]));
            Element salary = user.addElement("salary");
            salary.setText(String.valueOf(data[i][5]));
        }

        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setIndent(true);
        prettyPrint.setIndentSize(4);
        XMLWriter xmlWriter = null;
        try {
            xmlWriter = new XMLWriter(new FileWriter(file), prettyPrint);
            xmlWriter.write(document);
            xmlWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateData() {
        if (mainWin.getUser().isVisible()) {
            JTable userTable = mainWin.getUserTable();
            DefaultTableModel model = (DefaultTableModel) userTable.getModel();
            model.setRowCount(0);
            mainWin.addTableData(model);
        } else if (mainWin.getDepartment().isVisible()) {
            JTable userTable = mainWin.getDepartTable();
            DefaultTableModel model = (DefaultTableModel) userTable.getModel();
            model.setRowCount(0);
            mainWin.addDepartmentTableData(model);
        }
    }
}
