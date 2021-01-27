package com.restresponceentity.service;


import com.restresponceentity.entiry.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    List<Product> delete(Long id);

    List<Product> updateProduct(Long id, Product product);

    List<Product> createProduct(Product product);

    Product getProduct(Long id);

}
