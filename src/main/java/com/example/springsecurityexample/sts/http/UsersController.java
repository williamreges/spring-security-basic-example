package com.example.springsecurityexample.sts.http;

import com.example.springsecurityexample.sts.http.dto.UsersDTO;
import com.example.springsecurityexample.sts.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public String save(@Valid @RequestBody UsersDTO vO) {
        return usersService.save(vO).toString();
    }


}
