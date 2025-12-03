package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product{
    private final int cost;

    public SimpleProduct(UUID id, String name, int cost) {
        super(id, name);
        if (cost < 1) {
            throw new IllegalArgumentException();
        }
        this.cost = cost;
    }
    @Override
    public double getCost() {
        return cost;
    }
    public String toString() {
        return "Название: " + name + " стоимость: " + cost + ", ID " + id;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
