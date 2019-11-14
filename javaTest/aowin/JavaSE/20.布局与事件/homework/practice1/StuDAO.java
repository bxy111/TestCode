package practice1;

import java.sql.*;

public class StuDAO {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bxytest?characterEncoding=UTF-8&useSSL=false",
                "root", "123456");
        return con;
    }

    public Student queryByName(String name) {
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String s = "select classno, score from studentinfo where name=?";
            statement = connection.prepareStatement(s);
            statement.setString(1, name);

            resultSet = statement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                int classNo = resultSet.getInt(1);
                double score = resultSet.getDouble(2);
                student = new Student("", classNo, score);
            }
            return student;
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
            if (statement != null) {
                try {
                    statement.close();
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
        return null;
    }
}
