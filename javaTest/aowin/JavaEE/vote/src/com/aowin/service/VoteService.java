package com.aowin.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.aowin.dao.UserDao;
import com.aowin.dao.VoteDao;
import com.aowin.util.DBUtil;

public class VoteService {
	public int vote(String account,String mind) throws SQLException {
		Connection con=DBUtil.getCon();
		//改成手动提交
		con.setAutoCommit(false);
		
		//先判断该用户是否投过票
		UserDao ud=new UserDao();
		int status = ud.queryStatus(account);
		if(status==1) {
			return 1;
		}
		try {
			//表明没有投过票 -- 开始投票
			//修改票数
			int n1 = new VoteDao().updVote(mind, con);
			//修改用户投票状态
			int n2 = ud.updStatus(account, con);
			//事务处理 : 先将自动提交改成手动提交 然后根据执行结果选择回滚或者提交
			if (n1 == 1 && n2 == 1) {
				//执行成功 手动提交
				con.commit();
				return 2;
			} else {
				//至少有一条没成功 则所有操作包都不能成功 事务回滚
				con.rollback();
				return 3;
			} 
		} finally {
			DBUtil.close(null, null, con);
		}
		
	}
}
