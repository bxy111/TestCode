package Practice2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection root = null;
        try {
            root = DriverManager.getConnection("jdbc:mysql://localhost:3306/bxytest?characterEncoding=UTF-8&useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static void addPet(Pet p) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into petinfo(name, type, color, price) values (?, ?, ?, ?)";
        boolean needUpdate = false;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select count(*) from petinfo where type=?");
            preparedStatement.setString(1, "dog");
            resultSet = preparedStatement.executeQuery();
            int oldNum = 0;
            while (resultSet.next()) {
                oldNum = resultSet.getInt(1);
            }
            preparedStatement.close();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setString(2, p.getType());
            preparedStatement.setString(3, p.getColor());
            preparedStatement.setDouble(4, p.getPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = connection.prepareStatement("select count(*) from petinfo where type=?");
            preparedStatement.setString(1, "dog");
            resultSet = preparedStatement.executeQuery();
            int newNum = 0;
            while (resultSet.next()) {
                newNum = resultSet.getInt(1);
            }
            preparedStatement.close();

            if (newNum > oldNum && newNum == 6) {
                preparedStatement = connection.prepareStatement("update petinfo set price=price*0.6 where " +
                        "type=\"dog\"");
                preparedStatement.executeUpdate();
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void delPet(int id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from petinfo where id=?";
        boolean needUpdate = false;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select count(*) from petinfo where type=?");
            preparedStatement.setString(1, "dog");
            resultSet = preparedStatement.executeQuery();
            int oldNum = 0;
            while (resultSet.next()) {
                oldNum = resultSet.getInt(1);
            }
            preparedStatement.close();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = connection.prepareStatement("select count(*) from petinfo where type=?");
            preparedStatement.setString(1, "dog");
            resultSet = preparedStatement.executeQuery();
            int newNum = 0;
            while (resultSet.next()) {
                newNum = resultSet.getInt(1);
            }
            preparedStatement.close();

            if (newNum < oldNum && newNum == 5) {
                preparedStatement = connection.prepareStatement("update petinfo set price=price/0.6 where " +
                        "type=\"dog\"");
                preparedStatement.executeUpdate();
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static List<Pet> listPet(int type, String field) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = null;

        if (type == 1) {
            sql = "select * from petinfo where color=?";
        } else if (type == 2) {
            sql = "select * from petinfo where type=?";
        } else {
            sql = "select * from petinfo order by id";
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (type == 1 || type == 2) {
                preparedStatement.setString(1, field);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pet pet = new Pet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getDouble(5));
                pets.add(pet);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return pets;
    }
}
