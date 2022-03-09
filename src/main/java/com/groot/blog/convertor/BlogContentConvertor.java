package com.groot.blog.convertor;

import com.groot.blog.base.convertor.BaseConvertor;
import com.groot.blog.dto.BlogContentDTO;
import com.groot.blog.entity.BlogContent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogContentConvertor extends BaseConvertor<BlogContent, BlogContentDTO> {
    @Override
    public BlogContentDTO toDTO(BlogContent entity) {
        BlogContentDTO dto = new BlogContentDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public BlogContent toEntity(BlogContentDTO dto) {
        BlogContent entity = new BlogContent();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
