package com.aowin.service;

import java.sql.SQLException;

import com.aowin.dao.UserDao;

//业务层
public class AuthService {
	
	public boolean authCheck(String account,String path) throws SQLException {
		String auth=new UserDao().queryAuth(account);
		if(path.startsWith("/normal") || (path.startsWith("/vip")&&auth.equals("vip"))) {
			return true;
		}else {
			return false;
		}
	}
}
