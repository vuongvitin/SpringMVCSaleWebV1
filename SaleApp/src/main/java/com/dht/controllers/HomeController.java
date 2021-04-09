/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/")
    public String index(Model model, 
            @RequestParam(name = "cateId", required = false) String cateId,
            @RequestParam(name = "kw", required = false, defaultValue = "") String kw) {
        model.addAttribute("categories", this.categoryService.getCategories());
        if (cateId == null)
            model.addAttribute("products", this.productService.getProducts(kw));
        else
            model.addAttribute("products", 
                    this.categoryService.getCateById(Integer.parseInt(cateId)).getProducts());
        return "index";
    }
}
