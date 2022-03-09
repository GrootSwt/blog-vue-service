package com.groot.blog.convertor;

import com.groot.blog.base.convertor.BaseConvertor;
import com.groot.blog.dto.BlogCatalogueDTO;
import com.groot.blog.entity.BlogCatalogue;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogCatalogueConvertor extends BaseConvertor<BlogCatalogue, BlogCatalogueDTO> {
    @Override
    public BlogCatalogueDTO toDTO(BlogCatalogue blogCatalogue) {
        BlogCatalogueDTO dto = new BlogCatalogueDTO();
        BeanUtils.copyProperties(blogCatalogue, dto);
        return dto;
    }

    @Override
    public BlogCatalogue toEntity(BlogCatalogueDTO blogCatalogueDTO) {
        BlogCatalogue entity = new BlogCatalogue();
        BeanUtils.copyProperties(blogCatalogueDTO, entity);
        return entity;
    }
}
