package com.huimu.flowerplant.common.vo;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVo {

    private int pageNo = 1;

    private int pageSize = 2;

    public <T> Page<T> toPage() {
        return new Page<>(pageNo, pageSize);
    }

}
