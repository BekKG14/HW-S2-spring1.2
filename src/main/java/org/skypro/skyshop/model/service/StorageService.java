package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        loadInitialData();
    }

    public Collection<Product> getAllProducts() {
        return productStorage.values();
    }

    public Collection<Article> getAllArticles() {
        return articleStorage.values();
    }



    private void loadInitialData() {
        Product cucumber = new SimpleProduct(UUID.randomUUID(), "Cucumber", 20);
        Product vodka = new SimpleProduct(UUID.randomUUID(), "Vodka", 101);
        Product pivo = new SimpleProduct(UUID.randomUUID(), "Pivo", 80);
        Product pivoCheep = new DiscountProduct(UUID.randomUUID(), "Pivo Light", 29, 12);
        Product chlor = new FixPriceProduct(UUID.randomUUID(), "Chlor", 2313);
        Product cheetos = new DiscountProduct(UUID.randomUUID(), "Cheetos", 109, 10);
        Product maltesers = new FixPriceProduct(UUID.randomUUID(), "Maltesers", 129);
        Product coupon = new SimpleProduct(UUID.randomUUID(), "Netflix coupon", 499);
        productStorage.put(cucumber.getId(), cucumber);
        productStorage.put(vodka.getId(), vodka);
        productStorage.put(pivo.getId(), pivo);
        productStorage.put(pivoCheep.getId(), pivoCheep);
        productStorage.put(chlor.getId(), chlor);
        productStorage.put(cheetos.getId(), cheetos);
        productStorage.put(maltesers.getId(), maltesers);
        productStorage.put(coupon.getId(), coupon);
        Article alcohol = new Article(UUID.randomUUID(),"Vodka premium!", "Is premium vodka good for your ? No vodka is bad anyway");
        Article vegetables = new Article(UUID.randomUUID(),"Cucmber, or not cucumber? That is the question!", "Cucumber is good !");
        Article discount = new Article(UUID.randomUUID(),"Discount is for poor?", "No it's not, now discount products are cheetos and Pivo Light");
        articleStorage.put(alcohol.getId(), alcohol);
        articleStorage.put(vegetables.getId(), vegetables);
        articleStorage.put(discount.getId(), discount);
    }


    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }


    public Collection<Searchable> getAllSearchable() {
        List<Searchable> searchables = new ArrayList<>();
        searchables.addAll(getAllProducts());
        searchables.addAll(getAllArticles());
        return searchables;
    }


}