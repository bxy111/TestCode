package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aowin.model.User;
import com.aowin.util.DBUtil;

public class UserDao {
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
