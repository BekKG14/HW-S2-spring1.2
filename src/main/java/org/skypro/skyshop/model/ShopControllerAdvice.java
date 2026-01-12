package org.skypro.skyshop.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductHandler(NoSuchProductException e) {
        ShopError shopError = new ShopError("PRODUCT_NOT_FOUND", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ShopError("404", e.getMessage()));
    }



    //@ExceptionHandler(DivisionByZeroException.class)
    //   public ResponseEntity<String> divisionByZeroHandler
    //   (DivisionByZeroException e) {
    //      // Возвращаем статус 400 Bad Request с сообщением об ошибке
    //      return ResponseEntity.badRequest().body(e.getMessage());
    //   }
}
