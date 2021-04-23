/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.validator;

import com.dht.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */
@Component
public class UserPassValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.getPassword().equals(user.getConfirmPassword()))
            errors.rejectValue("password", "user.password.notmatch");
    }
    
}
