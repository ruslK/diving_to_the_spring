package com.restresponceentity.controller;

import com.restresponceentity.entiry.Product;
import com.restresponceentity.entiry.ResponseWrapper;
import com.restresponceentity.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Version", "Cybertek.V1");
        httpHeaders.set("Operation", "Get List");
        return ResponseEntity.ok().headers(httpHeaders).body(productService.getProducts());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Version", "Cybertek.V1");
        httpHeaders.set("Operation", "Delete");
        List<Product> list = productService.delete(id);
        return new ResponseEntity<>(list, httpHeaders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody() Product product) {
        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "V1")
                .header("Operation", "Create")
                .body(set);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "V1");
        map.add("Operation", "Update");

        List<Product> list = productService.updateProduct(id, product);
        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts() {
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved", productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct1(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(new ResponseWrapper("Product successfully deleted"));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> delete2 (@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("Product successfully deleted"));
    }
}
