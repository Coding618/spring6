package com.test.spring6.validator.two;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.validation.Validator;

import java.util.Set;

/**
 * 使用jakarta.validation.Validator作校验
 */
@Service
public class MyValidation1 {

    @Autowired
    private Validator validator;

    public boolean validatorByUserOne(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
