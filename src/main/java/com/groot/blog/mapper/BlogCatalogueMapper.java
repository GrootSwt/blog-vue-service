package com.groot.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groot.blog.entity.BlogCatalogue;

import java.util.List;

public interface BlogCatalogueMapper extends BaseMapper<BlogCatalogue> {

    List<BlogCatalogue> getNewest(String category);
}
