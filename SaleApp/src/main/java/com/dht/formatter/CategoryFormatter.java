/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.formatter;

import com.dht.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category t, Locale locale) {
        return t.toString();
    }

    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(id));
        
        return c;
    }
    
}
