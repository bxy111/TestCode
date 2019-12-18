package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aowin.model.User;
import com.aowin.util.DBUtil;

public class UserDao {
	//修改用户状态
	public int updStatus(String account,Connection con) throws SQLException {
//		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//con = DBUtil.getCon();
			String sql = "update user set status=1 where account=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, account);
			int n=ps.executeUpdate();
			return n;
		} finally {
			DBUtil.close(null, ps, null);//事务处理不能单独关闭连接
		}
	}
	
	//查询用户投票状态
	public int queryStatus(String account) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = DBUtil.getCon();
			String sql = "select status from user where account=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();
			int status=0;
			if (rs.next()) {//表示账号密码都正确 查出结果
				status=rs.getInt("status");
			}
			return status;
		} finally {
			DBUtil.close(rs, ps, con);
		}
	}
	
	//校验用户的登录过程
	public User  checkUser(String account,String password) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = DBUtil.getCon();
			String sql = "select name from user where account=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			User u = null;
			if (rs.next()) {//表示账号密码都正确 查出结果
				String name = rs.getString("name");
				u = new User(account, password, name);
			}
			return u;
		} finally {
			DBUtil.close(rs, ps, con);
		}
		
	}
}
