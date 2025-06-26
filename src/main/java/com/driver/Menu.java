package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final List<Food> foodList = new ArrayList<>();

    static {
        foodList.add(new Food(1, "Burger", 99.0));
        foodList.add(new Food(2, "Pizza", 199.0));
        foodList.add(new Food(3, "Pasta", 149.0));
        foodList.add(new Food(4, "Fries", 59.0));
        foodList.add(new Food(5, "Coke", 39.0));
    }

    public static List<Food> getMenu() {
        return foodList;
    }

    public static Food getItemById(int id) {
        return foodList.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }
}
