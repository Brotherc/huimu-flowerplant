package com.huimu.flowerplant.user.controller;

import com.huimu.flowerplant.common.web.Response;
import com.huimu.flowerplant.user.model.entity.User;
import com.huimu.flowerplant.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Response<User> getUserById(@PathVariable Integer id) {
        return Response.success(userService.getUserById(id));
    }

}
