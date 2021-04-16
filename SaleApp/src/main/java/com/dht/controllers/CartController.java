/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        model.addAttribute("cart", session.getAttribute("cart"));
        return "cart";
    }
}
