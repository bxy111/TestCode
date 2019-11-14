package com.aowin.run;

import java.sql.SQLException;

import com.aowin.dao.ZooDao;

public class Test {
	public static void main(String[] args) throws SQLException {
		ZooDao zd=new ZooDao();
		zd.insert();
	}
}
