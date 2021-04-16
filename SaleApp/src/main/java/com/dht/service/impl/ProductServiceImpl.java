/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service.impl;

import com.dht.pojo.Product;
import com.dht.repository.ProductRepository;
import com.dht.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getProducts(String kw) {
        return this.productRepository.getProducts(kw);
    }

    @Override
    public List<Product> getProducts(BigDecimal fromPrice, BigDecimal toPrice) {
        return this.productRepository.getProducts(fromPrice, toPrice);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return this.productRepository.deleteProduct(productId);
    }

    @Override
    public boolean addOrUpdateProduct(Product product) {
        return this.productRepository.addOrUpdateProduct(product);
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }
    
}
