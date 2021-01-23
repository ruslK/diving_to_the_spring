package com.rest1.controller;

import com.rest1.entiry.Product;
import com.rest1.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products/{id}")
    public @ResponseBody
    Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products")
    public @ResponseBody
    List<Product> getProducts() {
        return productService.getProducts();
    }

    @DeleteMapping(value = "/products/{id}")
    public @ResponseBody
    List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @PostMapping("/products")
    public @ResponseBody List<Product> postProduct(@RequestBody() Product  product) {
        return productService.createProduct(product);
    }
}
