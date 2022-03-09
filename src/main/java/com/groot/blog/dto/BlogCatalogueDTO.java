package com.groot.blog.dto;

import com.groot.blog.base.bean.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogCatalogueDTO extends BaseDTO {
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
    /**
     * 子目录
     */
    private List<BlogCatalogueDTO> children;
}
