package practice2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
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
            root = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bxytest?characterEncoding=UTF-8&useSSL=false", "root", "123456");
            return root;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static void insertPet(List<Pet> pets) {
        Connection connection = getConnection();

        String sql = "insert into petinfo(name, type, color, price) values(?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            for (Pet p : pets) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, p.getName());
                preparedStatement.setString(2, p.getType());
                preparedStatement.setString(3, p.getColor());
                preparedStatement.setDouble(4, p.getPrice());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
    }

    public static List<Pet> listAll() {
        Connection connection = getConnection();
        ArrayList<Pet> pets = new ArrayList<>();

        String sql = "select name,type,color,price from petinfo";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setName(resultSet.getString(1));
                pet.setType(resultSet.getString(2));
                pet.setColor(resultSet.getString(3));
                pet.setPrice(resultSet.getDouble(4));
                pets.add(pet);
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return pets;
    }
}
