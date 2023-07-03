package com.huimu.flowerplant.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BaseEntity {

    private Long createdUserId;

    private Long updatedUserId;

    private Date createdTime;

    private Date updatedTime;

}
