package com.aowin.utils;

import com.aowin.exception.FoodIsNotEnoughException;
import com.aowin.exception.FoodNameIsNotSupportException;
import com.aowin.exception.NumberIsInvalidException;

public interface Sale {
    public boolean saleFood(String name, String num) throws
            NumberIsInvalidException, FoodNameIsNotSupportException, FoodIsNotEnoughException;
}
