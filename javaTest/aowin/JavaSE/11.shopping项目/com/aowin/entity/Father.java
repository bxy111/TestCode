package com.aowin.entity;

import com.aowin.exception.FoodIsNotEnoughException;
import com.aowin.exception.FoodNameIsNotSupportException;
import com.aowin.exception.NumberIsInvalidException;
import com.aowin.utils.Food;

public class Father {
    static private Food[] foods;
    static private int index;

    public Father() {
        foods = new Food[3];
        index = 0;
    }
    private String exchange(String name){
        if ("1".equals(name)) {
            name = "苹果";
        } else if ("2".equals(name)){
            name = "梨子";
        } else if ("3".equals(name)){
            name = "香蕉";
        }
        return name;
    }
    private Food searchByName(String name) {
        name = exchange(name);
        for (int i = 0; i < index; i++) {
            if (foods[i] != null && foods[i].getName().equals(name)) {
                return foods[i];
            }
        }
        return null;
    }

    public void show() {
        if (index == 0) {
            System.out.println("家里没有吃的。");
            return;
        }
        System.out.println("目前，家中的食品清单:");
        for (int i = 0; i < index; i++) {
            if (foods[i].getCount() > 0) {
                System.out.println(foods[i].getName() + "\t" + foods[i].getCount() + "个");
            }
        }
    }

    public void eat(String name, String numStr) throws
            NumberIsInvalidException, FoodNameIsNotSupportException, FoodIsNotEnoughException {
        int num = 0;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new NumberIsInvalidException("吃东西时，数量需要为正整数，吃失败！");
        }
        if (num <= 0) {
            throw new NumberIsInvalidException("吃东西时，数量需要为正整数，吃失败！");
        }

        Food food = searchByName(name);
        if (food == null) {
            throw new FoodNameIsNotSupportException("想吃的东西,没有买，吃失败！");
        } else {
            if (food.getCount() == 0) {
                throw new FoodNameIsNotSupportException("想吃的东西,没有买，吃失败！");
            }
            if (num > food.getCount()) {
                throw new FoodIsNotEnoughException(exchange(name) + "数量不够，吃失败！");
            }
            food.setCount(food.getCount() - num);
        }
    }

    public boolean buyFood(String name, int num) throws NumberIsInvalidException, FoodNameIsNotSupportException {
        if (num <= 0) {
            throw new NumberIsInvalidException("买食物时，食物数量需要为正整数，购买失败！");
        }
        Food tmp = searchByName(name);
        if (tmp == null) {
            Food f = null;
            switch (name) {
                case "1":
                case "苹果": {
                    f = new Apple("苹果", num);
                    break;
                }
                case "2":
                case "梨子": {
                    f = new Pear("梨子", num);
                    break;
                }
                case "3":
                case "香蕉": {
                    f = new Banana("香蕉", num);
                    break;
                }
                default: {
                    throw new FoodNameIsNotSupportException("想要购买的食品,商店中没有，购买失败！");
                }
            }
            foods[index++] = f;
        } else {
            tmp.setCount(tmp.getCount() + num);
        }
        return true;
    }

}
