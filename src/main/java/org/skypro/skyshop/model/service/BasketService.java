package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.BasketItem;
import org.skypro.skyshop.model.UserBasket;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    @Autowired
    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductById(UUID uuid) {

        if (storageService.getProductById(uuid).isPresent() == false) {
            throw new IllegalArgumentException()
            ;
        }
        productBasket.addProduct(uuid);
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> productsInBasket = productBasket.getAllProducts();
        List<BasketItem> basketItems = productsInBasket.entrySet().stream()
                .map(entry -> {
                    UUID productId = entry.getKey();
                    int count = entry.getValue();
                    Product product = storageService.getProductById(productId)
                            .orElseThrow(() -> new IllegalStateException());
                    return new BasketItem(product, count);
                })
                .collect(Collectors.toList());
        return new UserBasket(basketItems);
    }
}
