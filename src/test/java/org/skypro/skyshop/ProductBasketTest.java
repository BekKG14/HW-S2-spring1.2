package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.skypro.skyshop.model.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProductBasketTest {
    @Test
    void addProduct_ShouldAddOneItem_WhenMapIsEmpty() {
        ProductBasket basket = new ProductBasket();
        UUID productId = UUID.randomUUID();

        basket.addProduct(productId);

        Map<UUID, Integer> products = basket.getAllProducts();
        assertEquals(1, products.size());
        assertTrue(products.containsKey(productId));
        assertEquals(1, products.get(productId));
    }

    @Test
    void addProduct_ShouldIncrementCount_WhenProductAlreadyExists() {
        ProductBasket basket = new ProductBasket();
        UUID productId = UUID.randomUUID();

        basket.addProduct(productId);
        basket.addProduct(productId);

        Map<UUID, Integer> products = basket.getAllProducts();
        assertEquals(1, products.size());
        assertEquals(2, products.get(productId));
    }

    @Test
    void getAllProducts_ShouldReturnUnmodifiableMap() {
        ProductBasket basket = new ProductBasket();
        Map<UUID, Integer> products = basket.getAllProducts();

        assertThrows(NoSuchProductException.class, () -> {
            products.put(UUID.randomUUID(), 1);
        });
    }
}

