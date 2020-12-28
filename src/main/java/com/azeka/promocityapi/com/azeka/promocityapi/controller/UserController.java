package com.azeka.promocityapi.com.azeka.promocityapi.controller;

import com.azeka.promocityapi.com.azeka.promocityapi.model.AppUser;
import com.azeka.promocityapi.com.azeka.promocityapi.service.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void register(@RequestBody AppUser appUser){
        userService.saveUser(appUser);
    }
}
