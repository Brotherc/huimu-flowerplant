package com.huimu.flowerplant.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huimu.flowerplant.common.vo.PageVo;
import com.huimu.flowerplant.user.dao.UserMapper;
import com.huimu.flowerplant.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    public Page<User> page(PageVo pageVo) {
        return userMapper.selectPage(pageVo.toPage(), null);
    }

    @Transactional
    public void addUser(User user) {
        userMapper.insert(user);
    }

}
