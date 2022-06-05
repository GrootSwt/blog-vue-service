package com.groot.blog.dto;

import com.groot.blog.base.bean.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class BlogRouteDTO extends BaseDTO {

    private String parentId;

    private String name;

    private String path;

    private List<BlogRouteDTO> children;
}
