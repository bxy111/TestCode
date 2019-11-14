package Practice2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestDemo {
    private static Scanner scanner = null;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            displayWelcome();
            int i = scanner.nextInt();
            switch (i) {
                case 1: {
                    displayPetInfo();
                    break;
                }
                case 2: {
                    System.out.println("请输入宠物的名字、类型、颜色、价格。");
                    String name = scanner.next();
                    String type = scanner.next();
                    String color = scanner.next();
                    double price = scanner.nextDouble();
                    try {
                        PetDao.addPet(new Pet(name, type, color, price));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    System.out.println("请输入宠物的id");
                    int id = scanner.nextInt();
                    try {
                        PetDao.delPet(id);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    System.exit(0);
                }
                default: {
                    System.err.println("输入异常");
                }
            }
        }
    }

    public static void displayPetInfo() {
        System.out.println("1.按照颜色显示");
        System.out.println("2.按照品种显示");
        System.out.println("3.全部显示");

        int select = scanner.nextInt();
        if (1 == select) {
            System.out.println("请输入颜色:");
            String color = scanner.next();
            try {
                List<Pet> pets = PetDao.listPet(select, color);
                printList(pets);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (2 == select) {
            System.out.println("请输入种类:");
            String type = scanner.next();
            try {
                List<Pet> pets = PetDao.listPet(select, type);
                printList(pets);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<Pet> pets = PetDao.listPet(select, null);
                printList(pets);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printList(List<Pet> pets) {
        System.out.printf("%4s%20s%20s%20s%20s", "id", "name", "type", "color", "price");
        System.out.println();
        for (Pet p : pets) {
            System.out.printf("%4d%20s%20s%20s\t%17.2f",
                    p.getId(), p.getName(), p.getType(), p.getColor(), p.getPrice());
            System.out.println();
        }
    }

    public static void displayWelcome() {
        System.out.println("1.显示宠物信息");
        System.out.println("2.进货宠物");
        System.out.println("3.卖掉宠物");
        System.out.println("4.退出程序");
        System.out.println("请输入选项（数字）:");
    }
}
