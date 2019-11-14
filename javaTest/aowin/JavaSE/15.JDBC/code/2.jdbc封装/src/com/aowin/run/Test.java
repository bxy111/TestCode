package com.aowin.run;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.aowin.dao.ZooDao;
import com.aowin.model.Zoo;

public class Test {
	public static void main(String[] args) throws SQLException {
		/*
		 * run:运行程序,
		 * model:存放的是与数据库中数据所对应的实体类 比如,Student类
		 * dao:存放操作数据库中数据的方法
		 * util:存放针对于数据库操作的工具类,比如获得连接
		 * 
		 * */
		Zoo z1=new Zoo(1005,"鹦鹉",20);
		ZooDao zd=new ZooDao();
		/*try {
			zd.insert(z1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		/*List<Zoo> l=zd.select();
		for(Zoo z:l) {
			System.out.println(z);
		}*/
		/*Zoo z=zd.select(1001);
		System.out.println(z);*/
		Zoo z=zd.select("大能猫 or '1'='1' ");
		System.out.println(z);
	}
}
