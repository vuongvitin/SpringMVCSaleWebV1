/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.Cart;
import com.dht.pojo.Product;
import com.dht.service.OrderService;
import com.dht.service.ProductService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiCartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void addProductToCart(@PathVariable(name = "productId") int productId,
            HttpSession session) {
        
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null)
            cart = new HashMap<>();
        
        if (cart.containsKey(productId) == true) { // sp có trong giỏ
            Cart c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else { // sp chưa có trong giỏ
            Product p = this.productService.getProductById(productId);
            Cart c = new Cart();
            c.setProductId(p.getId());
            c.setProductName(p.getName());
            c.setPrice(p.getPrice());
            c.setQuantity(1);
            
            cart.put(productId, c);
        }
        
        session.setAttribute("cart", cart);
    }
    
    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.OK)
    public void saveOrder(HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (this.orderService.addOrder(cart) == true)
            session.removeAttribute("cart");
    }
}
