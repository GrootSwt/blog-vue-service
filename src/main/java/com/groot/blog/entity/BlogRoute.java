package com.groot.blog.entity;

import com.groot.blog.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogRoute extends BaseEntity {

    private String parentId;

    private String name;

    private String path;
}
