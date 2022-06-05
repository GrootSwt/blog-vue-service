package com.groot.blog.convertor;

import com.groot.blog.base.convertor.BaseConvertor;
import com.groot.blog.dto.BlogRouteDTO;
import com.groot.blog.entity.BlogRoute;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogRouteConvertor extends BaseConvertor<BlogRoute, BlogRouteDTO> {
    @Override
    public BlogRouteDTO toDTO(BlogRoute entity) {
        BlogRouteDTO dto = new BlogRouteDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public BlogRoute toEntity(BlogRouteDTO dto) {
        BlogRoute model = new BlogRoute();
        BeanUtils.copyProperties(dto, model);
        return model;
    }
}
