package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aowin.model.Zoo;
import com.aowin.util.DbUtils;

public class ZooDao {
	//存放的都是针对于数据库中数据操作的方法(增删改查)
	//异常都抛出
	//1.插入数据
	/*public void insert(Zoo z) throws SQLException {
		Connection con=null;
		Statement st=null;
		try {
			con=DbUtils.getConnection();
			st=con.createStatement();
			int rows=st.executeUpdate("insert into zoo values("+z.getId()+", '"+z.getName()+"',"+z.getNumber()+")");
			if(rows>0) {
				System.out.println("成功插入一条数据");
			}else {
				System.out.println("插入失败");
			}
		}finally {
			con.close();
			st.close();
		}
	}*/
	//1.1使用PreparedStatement 来创建语句
	public void insert(Zoo z) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DbUtils.getConnection();
			//st=con.createStatement();
			//int rows=st.executeUpdate("insert into zoo values("+z.getId()+", '"+z.getName()+"',"+z.getNumber()+")");
			ps=con.prepareStatement("insert into zoo values(?,?,?)");
			ps.setInt(1, z.getId());
			ps.setString(2, z.getName());
			ps.setInt(3, z.getNumber());
			int rows=ps.executeUpdate();
			if(rows>0) {
				System.out.println("成功插入一条数据");
			}else {
				System.out.println("插入失败");
			}
		}finally {
			con.close();
			ps.close();
		}
	}
	
	
	//2.查询
	public List<Zoo> select() throws SQLException {
		Connection con=null;
		//Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Zoo> l=new ArrayList<Zoo>();
		try {
			con=DbUtils.getConnection();
			ps=con.prepareStatement("select * from zoo");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int number=rs.getInt("number");
				Zoo z=new Zoo(id, name, number);
				l.add(z);
			}
			return l;
		}finally {
			con.close();
			ps.close();
			rs.close();
		}
	}
	//3.指定条件查询
	public Zoo select(int id) throws SQLException {
		Connection con=null;
		//Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Zoo z=null;
		try {
			con=DbUtils.getConnection();
			ps=con.prepareStatement("select * from zoo where id= ?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id1=rs.getInt("id");
				String name=rs.getString("name");
				int number=rs.getInt("number");
				z=new Zoo(id1, name, number);
			
			}
			return z;
		}finally {
			con.close();
			ps.close();
			rs.close();
		}
	}
	public Zoo select(String name) throws SQLException {
		Connection con=null;
		//Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Zoo z=null;
		try {
			con=DbUtils.getConnection();
			ps=con.prepareStatement("select * from zoo where name= ?");
			ps.setString(1, name);
			rs=ps.executeQuery();
			//不好,可以通过参数来修改sql语句
			//解决:使用PreparedStatement来代替Statement
			//select * from zoo where name= ' ' or '1'='1' 
			while(rs.next()) {
				int id1=rs.getInt("id");
				String name1=rs.getString("name");
				int number=rs.getInt("number");
				z=new Zoo(id1, name1, number);
			
			}
			return z;
		}finally {
			con.close();
			ps.close();
			rs.close();
		}
	}
}
