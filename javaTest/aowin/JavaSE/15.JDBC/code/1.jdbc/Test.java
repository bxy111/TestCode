package com.aowin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * 
		 * 1.加载驱动类
		 * 2.获得与数据库的连接,通过DriverManager的静态方法getConnection()来获得连接对象
		 * 3.定义sql语句
		 * 4.通过Connection con来获得传送sql语句的Statement类型的对象
		 * 5.将字符串送到数据库中执行,并返回查询结果,封装到了ResultSet结果集中
		 * 6.遍历结果集
		 * 		使用rs.next(),该方法会返回boolean类型值,代表箭头下面是否还有元素
		 * 		如果有,可以通过rs.getInt("属性名")方法拿到对应的属性值
		 * 7.关闭所有连接资源
		 */
		Class.forName("com.mysql.jdbc.Driver");
		//通过jdbc连接mysql数据库,数据库在ip地址为localhost的电脑上的3306端口上,访问test数据库
		Connection con= null;
		Statement s=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "1234");
			System.out.println("连接成功");
			String sql="select * from student";
			//通过Connection 对象获得Statement
			s=con.createStatement();
			//将sql送到数据库中执行,并返回结果集
			rs=s.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("name");
				int id=rs.getInt("id");
				int age=rs.getInt("age");
				String sex=rs.getString("sex");
				String department =rs.getString("department");
				int classroom =rs.getInt("class");
				Student stu=new Student(id, name, age, sex, department, classroom);
				System.out.println(stu);
			}
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(s!=null) {
					s.close();
				}
				if(con!=null) {
					con.close();
				}
				System.out.println("资源已经断开");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
