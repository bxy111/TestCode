package Practice1;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        UserDao userDao = null;
        try {
            userDao = new UserDao();
        } catch (ClassNotFoundException e) {
            System.err.println("加载jdbc驱动失败");
        }

        System.out.println("请输入用户名和密码:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String password = scanner.next();

        if (!userDao.isExistUser(name, password)) {
            System.out.println("用户不存在");
            System.out.println("请输入数字，1.注册新用户 2.退出系统");
            String select = scanner.next();
            if ("1".equals(select)) {
                System.out.println("请输入注册的用户名、密码以及联系方式(手机号)");
                name = scanner.next();
                password = scanner.next();
                select = scanner.next();
                if (userDao.addUser(name, password, select)) {
                    System.out.println("新增用户成功");
                } else {
                    System.err.println("新增用户失败");
                }
            } else if ("2".equals(select)){
                System.out.println("系统退出");
                return;
            }
        } else {
            System.out.println("用户已经存在");
        }
    }
}
