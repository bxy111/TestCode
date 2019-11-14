package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aowin.util.DbUtils;

public class ZooDao {
	//批处理:将多个sql语句同时处理
	//1.Statement批处理
	/*public void insert() throws SQLException {
		Connection con=null;
		Statement st=null;
		try {
			con=DbUtils.getConnection();
			st=con.createStatement();
			for(int i=1006;i<1010;i++) {
				String sql="insert into zoo values("+i+",'小白兔',299)";
				//将sql加入到一个列表中,执行时,会执行该列表中的所有sql语句
				st.addBatch(sql);
				String sq1="delete from zoo where";
				st.addBatch(sq1);
			}
			//执行列表中的sql语句
			int a[]=st.executeBatch();
			for(int i=0;i<a.length;i++) {
				System.out.println(a[i]);
			}
		}finally {
			con.close();
			st.close();
		}
	}*/
	
	//2.PreparedStatement 的批处理
	public void insert() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DbUtils.getConnection();
			ps=con.prepareStatement("insert into zoo values(?,?,?)");
			for(int i=1020;i<1022;i++) {
				ps.setInt(1, i);
				ps.setString(2, "小猫");
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
