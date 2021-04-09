/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository;

import com.dht.pojo.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductRepository {
    List<Product> getProducts(String kw);
    List<Product> getProducts(BigDecimal fromPrice, BigDecimal toPrice);
    boolean deleteProduct(int productId);
}
