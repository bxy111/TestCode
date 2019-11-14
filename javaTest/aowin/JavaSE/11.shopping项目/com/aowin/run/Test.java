package com.aowin.run;

import com.aowin.entity.Father;
import com.aowin.entity.Shop;
import com.aowin.entity.Son;
import com.aowin.exception.FoodIsNotEnoughException;
import com.aowin.exception.FoodNameIsNotSupportException;
import com.aowin.exception.NumberIsInvalidException;

import java.util.Scanner;

public class Test {
    static Shop shop;
    static Father father;
    static Son son;
    static Scanner sc;

    public static void main(String[] args) {
        shop = new Shop();
        father = new Father();
        son = new Son();
        sc = new Scanner(System.in);

        shop.show();
        String ret;
        while (true) {
            System.out.println("是否需要进货? yes/no");
            ret = sc.next();
            if ("yes".equals(ret) || "no".equals(ret)) {
                break;
            }
        }
        if ("yes".equals(ret)) {
            while (true) {
                System.out.println("目前可以进货的名单【1.苹果 2.梨子 3.香蕉】！");
                System.out.println("请输入，想要进货的商品名和数量：");
                String name = sc.next();
                String num = sc.next();
                try {
                    shop.buyFood(name, num);
                    while (true) {
                        System.out.println("是否继续进货? yes/no");
                        ret = sc.next();
                        if ("yes".equals(ret) || "no".equals(ret)) {
                            break;
                        }
                    }
                    if ("no".equals(ret)) {
                        break;
                    }
                } catch (NumberIsInvalidException e) {
                    System.out.println(e.getMessage());
                } catch (FoodNameIsNotSupportException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("商品中没有商品，无法营业，再见！");
            return;
        }

        System.out.println("商店开门营业啦！");
        System.out.println("---------------------------------------");
        System.out.println("父亲来到商店中购买食品。");
        while (true) {
            shop.show();
            System.out.println("请输入想要购买的食品名称和数量：");
            String name = sc.next();
            String num = sc.next();
            try {
                shop.saleFood(name, num);
                father.buyFood(name, Integer.parseInt(num));
                while (true) {
                    System.out.println("是否继续购买食品? yes/no");
                    ret = sc.next();
                    if ("yes".equals(ret) || "no".equals(ret)) {
                        break;
                    }
                }
                if ("no".equals(ret)) {
                    break;
                }
            } catch (NumberIsInvalidException e) {
                System.out.println(e.getMessage());
            } catch (FoodNameIsNotSupportException e) {
                System.out.println(e.getMessage());
            } catch (FoodIsNotEnoughException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("父亲购买食品结束！");
        System.out.println("---------------------------------------");
        shop.show();

        System.out.println("父亲准备吃食物！");
        eatFood(father);
        System.out.println("父亲吃完食物了！");
        System.out.println("---------------------------------------");

        System.out.println("儿子准备吃食物！");
        eatFood(son);
        System.out.println("儿子吃完食物了！");
        son.show();
        System.out.println("程序结束，再见！");
    }

    public static void eatFood(Father obj){
        while (true) {
            obj.show();
            System.out.println("请输入想要吃的食物名称和数量：");
            String name = sc.next();
            String num = sc.next();
            try {
                obj.eat(name, num);
                String ret;
                while (true) {
                    System.out.println("是否继续吃食物? yes/no");
                    ret = sc.next();
                    if ("yes".equals(ret) || "no".equals(ret)) {
                        break;
                    }
                }
                if ("no".equals(ret)) {
                    break;
                }
            } catch (NumberIsInvalidException e) {
                System.out.println(e.getMessage());
            } catch (FoodNameIsNotSupportException e) {
                System.out.println(e.getMessage());
            } catch (FoodIsNotEnoughException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
