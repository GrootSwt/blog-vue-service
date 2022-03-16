package com.groot.blog.service;


import com.groot.blog.dto.BlogCatalogueDTO;
import com.groot.blog.entity.BlogCatalogue;

import java.util.List;

public interface BlogCatalogueService {
    List<BlogCatalogueDTO> getCatalogueTree(String category);

    void createCatalogue(BlogCatalogue blogCatalogue);

    void deleteByIdArr(String[] idArr);

    List<BlogCatalogue> getNewest();
}
