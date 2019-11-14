package Practice1;

import java.sql.*;

public class UserDao {
    public UserDao() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public boolean isExistUser(String username, String password) {
        Connection root = null;
        boolean isExist = false;
        String sql = "select id from user where name=? and password=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            root = DriverManager.getConnection("jdbc:mysql://localhost:3306/bxytest?characterEncoding=UTF-8&useSSL=false", "root", "123456");
            preparedStatement = root.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                isExist = true;
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
            if (root != null) {
                try {
                    root.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return isExist;
    }

    public boolean addUser(String username, String password, String contact){
        Connection root = null;
        boolean isSuccess = false;
        String sql = "insert into user(name, password, contact) values (?, ?, ?)";
        PreparedStatement preparedStatement = null;

        try {
            root = DriverManager.getConnection("jdbc:mysql://localhost:3306/bxytest?characterEncoding=UTF-8&useSSL=false", "root", "123456");
            preparedStatement = root.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, contact);
            int i = preparedStatement.executeUpdate();
            if (1 == i) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (root != null) {
                try {
                    root.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }
}
