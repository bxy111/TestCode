package com.aowin.entity;

import com.aowin.exception.FoodIsNotEnoughException;
import com.aowin.exception.FoodNameIsNotSupportException;
import com.aowin.exception.NumberIsInvalidException;
import com.aowin.utils.Buy;
import com.aowin.utils.Food;
import com.aowin.utils.Sale;

public class Shop implements Buy, Sale {
    private Food[] foods;
    private int index;

    public Shop() {
        foods = new Food[3];
        index = 0;
    }

    private String exchange(String name) {
        if ("1".equals(name)) {
            name = "苹果";
        } else if ("2".equals(name)) {
            name = "梨子";
        } else if ("3".equals(name)) {
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
            System.out.println("商店目前是空的。");
            return;
        }
        System.out.println("商店的商品清单:");
        for (int i = 0; i < index; i++) {
            if (foods[i].getCount() > 0) {
                System.out.println(foods[i].getName() + "\t" + foods[i].getCount() + "个");
            }
        }
    }

    @Override
    public boolean buyFood(String name, String numStr) throws NumberIsInvalidException, FoodNameIsNotSupportException {
        int num = 0;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new NumberIsInvalidException("商店进货时，商品数量需要为正整数，进货失败！");
        }
        if (num <= 0) {
            throw new NumberIsInvalidException("商店进货时，商品数量需要为正整数，进货失败！");
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
                    throw new FoodNameIsNotSupportException("商店想要进货的商品,没有厂家在卖，进货失败！");
                }
            }
            foods[index++] = f;
        } else {
            tmp.setCount(tmp.getCount() + num);
        }
        return true;
    }

    @Override
    public boolean saleFood(String name, String numStr) throws NumberIsInvalidException, FoodNameIsNotSupportException,
            FoodIsNotEnoughException {
        int num = 0;
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new NumberIsInvalidException("顾客购买时，商品数量需要为正整数，购买失败！");
        }
        if (num <= 0) {
            throw new NumberIsInvalidException("顾客购买时，商品数量需要为正整数，购买失败！");
        }

        Food food = searchByName(name);
        if (food == null) {
            throw new FoodNameIsNotSupportException("顾客想购买的商品,商店中没有，购买失败！");
        } else {
            if (food.getCount() == 0) {
                throw new FoodNameIsNotSupportException("顾客想购买的商品,商店中没有，购买失败！");
            }
            if (num > food.getCount()) {
                throw new FoodIsNotEnoughException(exchange(name) + "数量不够，顾客购买失败！");
            }
            food.setCount(food.getCount() - num);
        }
        return false;
    }
}
