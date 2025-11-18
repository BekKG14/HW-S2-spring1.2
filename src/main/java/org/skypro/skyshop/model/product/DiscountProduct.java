package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountProduct extends Product{
    private double baseCost;
    private double discountProcent;

    public DiscountProduct(UUID id, String name,double baseCost, double discountProcent){
        super(id, name);
        this.baseCost = baseCost;
        this.discountProcent = discountProcent;
    }

    public double getCost() {
        double cost = baseCost;
        if (discountProcent > 0) {
            cost = baseCost * (1 - discountProcent / 100);
            return cost;
        } else {
            throw new IllegalArgumentException("Некоректные цифры");
        }
    }
        public String toString() {
            return "Название: " + name + " стоимость: " + getCost() + " скидка: " + discountProcent + "%" + " Id: " + id;
        }

        public boolean isSpecial() {
            return true;
        }
}

