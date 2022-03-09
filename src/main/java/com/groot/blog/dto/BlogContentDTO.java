package com.groot.blog.dto;

import com.groot.blog.base.bean.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogContentDTO extends BaseDTO {
    /**
     * 文件id
     */
    private String fileId;
    /**
     * 文件内容
     */
    private String text;
}
