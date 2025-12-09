package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Configuration
@SessionScope
public class ProductBasket<Product> {
    private final Map<UUID, Integer> products;

    public ProductBasket() {
        this.products = new HashMap<>();
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
}