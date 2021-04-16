/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.Cart;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import com.dht.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartStats", Utils.getCartStats((Map<Integer, Cart>) session.getAttribute("cart")));
    }
    
    @RequestMapping("/")
    public String index(Model model, 
            @RequestParam(name = "cateId", required = false) String cateId,
            @RequestParam(name = "kw", required = false, defaultValue = "") String kw) {
        
        if (cateId == null)
            model.addAttribute("products", this.productService.getProducts(kw));
        else
            model.addAttribute("products", 
                    this.categoryService.getCateById(Integer.parseInt(cateId)).getProducts());
        return "index";
    }
}
