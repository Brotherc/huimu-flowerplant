package com.huimu.flowerplant.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huimu.flowerplant.common.vo.PageVo;
import com.huimu.flowerplant.common.web.Response;
import com.huimu.flowerplant.user.model.entity.User;
import com.huimu.flowerplant.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Response<User> getUserById(@PathVariable Integer id) {
        return Response.success(userService.getUserById(id));
    }

    @GetMapping("/page")
    public Response<Page<User>> page(PageVo pageVo) {
        return Response.success(userService.page(pageVo));
    }

    @PostMapping("/addUser")
    public Response<Void> addUser() {
        User user = new User();
        user.setMobile("asdasd");
        user.setUserType(1);
        user.setUsername("lcs");
        user.setPassword("asdsadasdas");
        user.setCreatedUserId(123);
        user.setUpdatedUserId(123);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        userService.addUser(user);
        return Response.success();
    }

}
