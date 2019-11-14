package com.aowin.stuff.Dbconnection;

import com.aowin.stuff.Model.Department;
import com.aowin.stuff.Model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class DepartMentDAO {
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

    public ArrayList<Department> queryAll() {
        Connection connection = getConnection();
        if (connection == null) {
            return null;
        }
        ArrayList<Department> people = new ArrayList<>();
        String sql = "select * from department";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department person = new Department();
                int id = resultSet.getInt(1);
                person.setId(id);
                String name = resultSet.getString(2);
                person.setName(name);
                String manager = resultSet.getString(3);
                person.setManagerName(manager);
                people.add(person);
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
        return people;
    }

    public void delDataById(Integer id) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }
        String sql = "delete from department where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
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
    }

    public void insertData(Department p) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }

        String sql = "insert into department(NAME, Manager) values (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setString(2, p.getManagerName());
            preparedStatement.executeUpdate();
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
    }

    public void updateData(Department p) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }

        String sql = "update department set NAME=?,Manager=? where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setString(2, p.getManagerName());
            preparedStatement.setInt(3, p.getId());
            preparedStatement.executeUpdate();
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
    }

    public ArrayList<Department> queryByString(String conditon) {
        Connection connection = getConnection();
        if (connection == null) {
            return null;
        }
        System.out.println(conditon);
        ArrayList<Department> people = new ArrayList<>();
        String sql = "select * from department where " + conditon;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department person = new Department();
                int id = resultSet.getInt(1);
                person.setId(id);
                String name = resultSet.getString(2);
                person.setName(name);
                String manager = resultSet.getString(3);
                person.setManagerName(manager);
                people.add(person);
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
        return people;
    }

    public Vector<String> queryDepartmentName() {
        Connection connection = getConnection();
        if (connection == null) {
            return null;
        }
        Vector<String> departmentName = new Vector<>();
        String sql = "select distinct NAME from department";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                departmentName.add(name);
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
        return departmentName;
    }

    public void insertData(ArrayList<Department> ps) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }
        String sql = "insert into department(ID, NAME, Manager) values (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (Department p : ps) {
                preparedStatement.setInt(1, p.getId());
                preparedStatement.setString(2, p.getName());
                preparedStatement.setString(3, p.getManagerName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
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
    }
}
