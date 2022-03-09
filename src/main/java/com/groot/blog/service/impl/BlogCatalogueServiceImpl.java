package com.groot.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.groot.blog.convertor.BlogCatalogueConvertor;
import com.groot.blog.dto.BlogCatalogueDTO;
import com.groot.blog.entity.BlogCatalogue;
import com.groot.blog.entity.BlogContent;
import com.groot.blog.mapper.BlogCatalogueMapper;
import com.groot.blog.mapper.BlogContentMapper;
import com.groot.blog.service.BlogCatalogueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogCatalogueServiceImpl implements BlogCatalogueService {

    @Resource
    private BlogCatalogueMapper blogCatalogueMapper;
    @Resource
    private BlogCatalogueConvertor blogCatalogueConvertor;
    @Resource
    private BlogContentMapper blogContentMapper;

    @Override
    public List<BlogCatalogueDTO> getCatalogueTree(String category) {
        QueryWrapper<BlogCatalogue> wrapper = new QueryWrapper<>();
        wrapper.eq("category", category);
        List<BlogCatalogue> catalogues = blogCatalogueMapper.selectList(wrapper);
        List<BlogCatalogueDTO> blogCatalogueDTOs = blogCatalogueConvertor.toListDTO(catalogues);
        BlogCatalogueDTO root = new BlogCatalogueDTO();
        root.setChildren(blogCatalogueDTOs);
        this.listToTree(root, blogCatalogueDTOs, "-1");
        return root.getChildren();
    }

    private void listToTree(BlogCatalogueDTO root, List<BlogCatalogueDTO> blogCatalogueDTOs, String parentId) {
        List<BlogCatalogueDTO> subList = new ArrayList<>();
        for (BlogCatalogueDTO dto : blogCatalogueDTOs) {
            if (parentId.equals(dto.getParentId())) {
                subList.add(dto);
                this.listToTree(dto, blogCatalogueDTOs, dto.getId());
            }
        }
        root.setChildren(subList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCatalogue(BlogCatalogue blogCatalogue) {
        Date date = new Date();
        blogCatalogue.setCreateTime(date);
        blogCatalogue.setLastUpdateTime(date);
        blogCatalogueMapper.insert(blogCatalogue);
        // 目录类型为文章时创建文章内容
        if ("2".equals(blogCatalogue.getType())) {
            BlogContent blogContent = new BlogContent();
            blogContent.setFileId(blogCatalogue.getId());
            blogContent.setCreateTime(date);
            blogCatalogue.setLastUpdateTime(date);
            blogContentMapper.insert(blogContent);
        }

    }
}
