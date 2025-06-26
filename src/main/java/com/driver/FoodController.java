package com.driver;


import com.example.foodorderapi.model.Food;
import com.example.foodorderapi.model.Menu;
import com.example.foodorderapi.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @GetMapping("/menu")
    public List<Food> getMenu() {
        return Menu.getMenu();
    }

    @PostMapping("/order/{itemID}")
    public String placeOrder(@PathVariable int itemID) {
        Food item = Menu.getItemById(itemID);
        if (item != null) {
            Order.addItem(item);
            return item.getName() + " added to your order.";
        } else {
            return "Item not found.";
        }
    }

    @GetMapping("/order")
    public List<Food> getOrder() {
        return Order.getOrderItems();
    }

    @GetMapping("/order/total")
    public String getTotalBill() {
        return "Total Bill: ₹" + Order.getTotal();
    }
}
