package com.groot.blog.entity;

import com.groot.blog.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 博客文件内容
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogContent extends BaseEntity {
    /**
     * 文件id
     */
    private String fileId;
    /**
     * 文件内容
     */
    private String text;
}
