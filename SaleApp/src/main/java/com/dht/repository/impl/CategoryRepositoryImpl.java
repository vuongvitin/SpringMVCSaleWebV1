/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.Category;
import com.dht.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public List<Category> getCategories() {
        List<Category> cates = new ArrayList<>();
        Category c1 = new Category();
        c1.setId(1);
        c1.setName("Mobile");
        Category c2 = new Category();
        c2.setId(2);
        c2.setName("Tablet");
        
        cates.add(c1);
        cates.add(c2);
        
        return cates;
    }
    
}
