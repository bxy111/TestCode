package com.aowin.run;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.aowin.dao.ZooDao;
import com.aowin.model.Zoo;

public class Test {
	public static void main(String[] args) throws SQLException {
		/*
		 * run:���г���,
		 * model:��ŵ��������ݿ�����������Ӧ��ʵ���� ����,Student��
		 * dao:��Ų������ݿ������ݵķ���
		 * util:�����������ݿ�����Ĺ�����,����������
		 * 
		 * */
		Zoo z1=new Zoo(1005,"����",20);
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
		Zoo z=zd.select("����è or '1'='1' ");
		System.out.println(z);
	}
}
