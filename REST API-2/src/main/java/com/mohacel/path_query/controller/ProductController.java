package com.mohacel.path_query.controller;

import com.mohacel.path_query.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping(value = "/product", produces = {"application/xml", "application/json"})
    public ResponseEntity<Product> productInfo(){
        Product product =new Product(101,"RAM",4500.00);
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }
}
