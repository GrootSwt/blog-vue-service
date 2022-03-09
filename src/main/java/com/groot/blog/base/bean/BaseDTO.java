package com.groot.blog.base.bean;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {

    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;
}
