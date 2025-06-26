package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final List<Food> orderItems = new ArrayList<>();

    public static void addItem(Food food) {
        orderItems.add(food);
    }

    public static List<Food> getOrderItems() {
        return orderItems;
    }

    public static double getTotal() {
        return orderItems.stream().mapToDouble(Food::getPrice).sum();
    }
}
