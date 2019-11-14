package com.aowin.stuff.Dbconnection;

import com.aowin.stuff.Model.UserInfo;

import java.sql.*;

public class UserDAO {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bxytest?characterEncoding=UTF-8&useSSL=false",
                    "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public boolean queryUser(UserInfo userInfo) {
        Connection connection = getConnection();
        if (connection == null) {
            return false;
        }

        boolean ret = false;

        String sql = "select count(*) from userinfo where UserName=? and PassWord=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userInfo.getName());
            preparedStatement.setString(2, userInfo.getPassword());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                if ("1".equals(string)) {
                    ret = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }
}
