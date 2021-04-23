/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.User;
import com.dht.service.UserService;
import com.dht.validator.WebAppValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private WebAppValidator userValidator;
    
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, 
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        
        if (this.userDetailsService.addUser(user) == false)  {
            model.addAttribute("errMsg", "Something wrong!!!");
            return "register";
        }
            
        
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
}
