package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aowin.util.DbUtils;

public class ZooDao {
	//������:�����sql���ͬʱ����
	//1.Statement������
	/*public void insert() throws SQLException {
		Connection con=null;
		Statement st=null;
		try {
			con=DbUtils.getConnection();
			st=con.createStatement();
			for(int i=1006;i<1010;i++) {
				String sql="insert into zoo values("+i+",'С����',299)";
				//��sql���뵽һ���б���,ִ��ʱ,��ִ�и��б��е�����sql���
				st.addBatch(sql);
				String sq1="delete from zoo where";
				st.addBatch(sq1);
			}
			//ִ���б��е�sql���
			int a[]=st.executeBatch();
			for(int i=0;i<a.length;i++) {
				System.out.println(a[i]);
			}
		}finally {
			con.close();
			st.close();
		}
	}*/
	
	//2.PreparedStatement ��������
	public void insert() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DbUtils.getConnection();
			ps=con.prepareStatement("insert into zoo values(?,?,?)");
			for(int i=1020;i<1022;i++) {
				ps.setInt(1, i);
				ps.setString(2, "Сè");
				ps.setInt(3,100);
				ps.addBatch();
			}
			int a[]=ps.executeBatch();
			for(int i=0;i<a.length;i++) {
				System.out.println(a[i]);
			}
		}finally {
			con.close();
			ps.close();
		}
	}
	
	
	
}
