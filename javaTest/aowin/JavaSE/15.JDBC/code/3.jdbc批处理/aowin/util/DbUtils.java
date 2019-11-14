package com.aowin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("success");
		} catch (ClassNotFoundException e) {
			System.out.println("加载失败");
			e.printStackTrace();
		}
	}
	public static Connection getConnection()  {
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			System.out.println("success");
		} catch (SQLException e) {
			System.out.println("获得连接失败");
			e.printStackTrace();
		}
		return con;
	}
}
