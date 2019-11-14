package com.aowin.stuff.Dbconnection;

import com.aowin.stuff.Model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAO {
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

    public ArrayList<Person> queryAll() {
        Connection connection = getConnection();
        if (connection == null) {
            return null;
        }

        ArrayList<Person> people = new ArrayList<>();
        String sql = "select * from person";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                int id = resultSet.getInt(1);
                person.setId(id);
                String name = resultSet.getString(2);
                person.setName(name);
                int sex = resultSet.getInt(3);
                if (sex == 1) {
                    person.setSex("男");
                } else if (sex == 0) {
                    person.setSex("女");
                }
                String department = resultSet.getString(4);
                person.setDepartment(department);
                int salary = resultSet.getInt(5);
                person.setSalary(salary);
                int age = resultSet.getInt(6);
                person.setAge(age);

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
        String sql = "delete from person where id=?";
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

    public void insertData(Person p) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }
        String sql = "insert into person(Name, Sex, Department, Salary, Age) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setInt(2, p.getSex().equals("男") ? 1 : 0);
            preparedStatement.setString(3, p.getDepartment());
            preparedStatement.setInt(4, p.getSalary());
            preparedStatement.setInt(5, p.getAge());
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

    public void insertData(ArrayList<Person> ps) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }
        String sql = "insert into person(Id, Name, Sex, Department, Salary, Age) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (Person p : ps) {
                preparedStatement.setInt(1, p.getId());
                preparedStatement.setString(2, p.getName());
                preparedStatement.setInt(3, p.getSex().equals("男") ? 1 : 0);
                preparedStatement.setString(4, p.getDepartment());
                preparedStatement.setInt(5, p.getSalary());
                preparedStatement.setInt(6, p.getAge());
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

    public void updateData(Person p) {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }

        String sql = "update person set Name=?,Sex=?,Department=?,Salary=?,Age=? where id=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setInt(2, p.getSex().equals("男") ? 1 : 0);
            preparedStatement.setString(3, p.getDepartment());
            preparedStatement.setInt(4, p.getSalary());
            preparedStatement.setInt(5, p.getAge());
            preparedStatement.setInt(6, p.getId());
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

    public ArrayList<Person> queryByString(String conditon) {
        Connection connection = getConnection();
        if (connection == null) {
            return null;
        }
        System.out.println(conditon);
        ArrayList<Person> people = new ArrayList<>();
        String sql = "select * from person where " + conditon;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Person person = new Person();
                int id = resultSet.getInt(1);
                person.setId(id);
                String name = resultSet.getString(2);
                person.setName(name);
                int sex = resultSet.getInt(3);
                if (sex == 1) {
                    person.setSex("男");
                } else if (sex == 0) {
                    person.setSex("女");
                }
                String department = resultSet.getString(4);
                person.setDepartment(department);
                int salary = resultSet.getInt(5);
                person.setSalary(salary);
                int age = resultSet.getInt(6);
                person.setAge(age);

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
}
