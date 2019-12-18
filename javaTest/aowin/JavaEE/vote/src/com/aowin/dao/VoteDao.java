package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.model.Vote;
import com.aowin.util.DBUtil;

public class VoteDao {
	//投票
	public int updVote(String mind,Connection con) throws SQLException {
//		Connection con=null;
		PreparedStatement ps=null;
		//con = DBUtil.getCon();
		try {
			String sql = "update vote set num=num+1 where mind=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mind);
			int n = ps.executeUpdate();
			
			return n;
		} finally {
			DBUtil.close(null, ps, null);//事务处理 不能单独关闭连接
		}
	}
	
	//查票数
	public ArrayList<Vote> query() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con = DBUtil.getCon();
		try {
			String sql = "select * from vote";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<Vote> al = new ArrayList<>();
			while (rs.next()) {
				String mind = rs.getString("mind");
				int num = rs.getInt("num");
				al.add(new Vote(mind, num));
			}
			return al;
		} finally {
			DBUtil.close(rs, ps, con);
		}
		
	}
}
