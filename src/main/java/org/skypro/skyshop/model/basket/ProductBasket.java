package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

import java.util.*;

public class ProductBasket<P extends Product> {
    private final Map<String, List<P>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(P p) {
        products.computeIfAbsent(p.getName(), k -> new ArrayList<>()).add(p);
    }

    public long isSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(p -> p.isSpecial())
                .count();
    }

    public double totalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getCost)
                .sum();
    }

    public void printAllProducts() {
        if(products.isEmpty()){
            System.out.println("Корзина пуста");
        } else {
            products.values().stream()
                    .flatMap(Collection::stream)
                    .forEach(p -> System.out.println(p.toString()));
        }
    }
    // ДОПИСАТЬ КОД И ПОНЯТЬ ЧТО ТУТ НАПИСАНО ВООБЩЕ
    
}
