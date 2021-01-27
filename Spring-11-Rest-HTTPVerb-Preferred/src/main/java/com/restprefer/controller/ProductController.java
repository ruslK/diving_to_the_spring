package com.restprefer.controller;

import com.restprefer.entiry.Product;
import com.restprefer.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @DeleteMapping(value = "/{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @PostMapping
    public List<Product> postProduct(@RequestBody() Product product) {
        return productService.createProduct(product);
    }

    @PutMapping(value = "/{id}")
    public List<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
