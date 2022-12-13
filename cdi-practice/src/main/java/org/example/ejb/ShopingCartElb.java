package org.example.ejb;

import org.example.entity.Item;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class ShopingCartElb {
    private List<Item> cartItems = new ArrayList<>();

    public void addItem(Item item) {
        if (!cartItems.contains(item)) {
            cartItems.add(item);
        }
    }

    public void removeItem(Item item) {
        if (cartItems.contains(item)) {
            cartItems.remove(item);
        }
    }

    public Integer count() {
        if (cartItems == null || cartItems.isEmpty()) {
            return 0;
        }
        return cartItems.size();
    }

    public Double getTotal() {
        if (cartItems == null || cartItems.isEmpty()) {
            return 0.0;
        }
        Double totalPrice = 0.0;
        for (Item item : cartItems) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void empty() {
        cartItems.clear();
    }

    @Remove
    public void checkout() {
        cartItems.clear();
    }
}
