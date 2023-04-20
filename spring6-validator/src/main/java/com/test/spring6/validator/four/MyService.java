package com.test.spring6.validator.four;

import com.test.spring6.validator.four.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {

    public String testMethod(@NotNull @Valid User user) {
        return user.toString();
    }

}
