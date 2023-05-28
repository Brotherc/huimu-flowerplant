package com.huimu.flowerplant.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.huimu.flowerplant.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    private Integer userType;

    private String mobile;

}
