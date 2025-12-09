package org.skypro.skyshop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        this.items = new ArrayList<>(items);
        this.total = this.items.stream()
                .mapToDouble(item -> item.getProduct().getCost() * item.getCount())
                .sum();
    }
}
