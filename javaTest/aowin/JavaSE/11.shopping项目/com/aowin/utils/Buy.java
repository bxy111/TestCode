package com.aowin.utils;

import com.aowin.exception.FoodNameIsNotSupportException;
import com.aowin.exception.NumberIsInvalidException;

public interface Buy {
    public boolean buyFood(String name, String num) throws
            NumberIsInvalidException, FoodNameIsNotSupportException;
}
