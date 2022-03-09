package com.groot.blog.entity;

import com.groot.blog.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 博客目录
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogCatalogue extends BaseEntity {
    /**
     * 父目录主键
     */
    private String parentId;
    /**
     * 目录名
     */
    private String name;
    /**
     * 目录类型（1：文件夹；2：文件）
     */
    private String type;
    /**
     * 目录种类
     */
    private String category;
}
