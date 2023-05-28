package com.huimu.flowerplant.user.service;

import com.huimu.flowerplant.user.dao.UserMapper;
import com.huimu.flowerplant.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

}
