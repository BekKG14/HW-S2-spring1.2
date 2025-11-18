package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product{
    private final double fixedCost;

    public FixPriceProduct(UUID id, String name, double fixedCost) {
        super(id,name);

        this.fixedCost = fixedCost;
    }

    public double getCost() {
        return fixedCost;
    }

    @Override
    public String toString() {
        return "Назавние товара: " + name + " фиксированная стоимость: " + fixedCost + ", id: " + id;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}
