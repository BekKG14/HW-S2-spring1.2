package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Configuration
@SessionScope
public class ProductBasket<P extends Product> {
    private final Map<UUID, Integer> products;
    private final StorageService storageService;

    public ProductBasket(StorageService storageService) {
        this.products = new HashMap<>();
        this.storageService = storageService;
    }


    public void addProduct(UUID id) {

        if (products.containsKey(id)) {
            int i = products.get(id);
            products.put(id, i + 1);
        } else {
            products.put(id, 1);
        }
    }

    public Map<UUID, Integer> getAllProducts() {
        return Collections.unmodifiableMap(products);
    }



//    public long isSpecialCount() {
//        return products.values().stream()
//                .flatMap(Collection::stream)
//                .filter(p -> p.isSpecial())
//                .count();
//    }
//
//    public double totalCost() {
//        return products.values().stream()
//                .flatMap(Collection::stream)
//                .mapToDouble(Product::getCost)
//                .sum();
//    }
//
//    public void printAllProducts() {
//        if (products.isEmpty()) {
//            System.out.println("Корзина пуста");
//        } else {
//            products.values().stream()
//                    .flatMap(Collection::stream)
//                    .forEach(p -> System.out.println(p.toString()));
//        }
//    }
    // ДОПИСАТЬ КОД И ПОНЯТЬ ЧТО ТУТ НАПИСАНО ВООБЩЕ
}