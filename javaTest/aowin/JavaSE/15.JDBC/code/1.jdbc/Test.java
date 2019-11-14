package com.aowin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * 
		 * 1.����������
		 * 2.��������ݿ������,ͨ��DriverManager�ľ�̬����getConnection()��������Ӷ���
		 * 3.����sql���
		 * 4.ͨ��Connection con����ô���sql����Statement���͵Ķ���
		 * 5.���ַ����͵����ݿ���ִ��,�����ز�ѯ���,��װ����ResultSet�������
		 * 6.���������
		 * 		ʹ��rs.next(),�÷����᷵��boolean����ֵ,�����ͷ�����Ƿ���Ԫ��
		 * 		�����,����ͨ��rs.getInt("������")�����õ���Ӧ������ֵ
		 * 7.�ر�����������Դ
		 */
		Class.forName("com.mysql.jdbc.Driver");
		//ͨ��jdbc����mysql���ݿ�,���ݿ���ip��ַΪlocalhost�ĵ����ϵ�3306�˿���,����test���ݿ�
		Connection con= null;
		Statement s=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "1234");
			System.out.println("���ӳɹ�");
			String sql="select * from student";
			//ͨ��Connection ������Statement
			s=con.createStatement();
			//��sql�͵����ݿ���ִ��,�����ؽ����
			rs=s.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("name");
				int id=rs.getInt("id");
				int age=rs.getInt("age");
				String sex=rs.getString("sex");
				String department =rs.getString("department");
				int classroom =rs.getInt("class");
				Student stu=new Student(id, name, age, sex, department, classroom);
				System.out.println(stu);
			}
		} catch (SQLException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(s!=null) {
					s.close();
				}
				if(con!=null) {
					con.close();
				}
				System.out.println("��Դ�Ѿ��Ͽ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
