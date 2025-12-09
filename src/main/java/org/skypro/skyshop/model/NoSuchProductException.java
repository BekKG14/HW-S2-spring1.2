package org.skypro.skyshop.model;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException(String message) {
        super("Нет такого продукта");
    }
}
