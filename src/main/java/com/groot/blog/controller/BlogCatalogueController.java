package com.groot.blog.controller;

import com.groot.blog.base.bean.ResultData;
import com.groot.blog.convertor.BlogCatalogueConvertor;
import com.groot.blog.dto.BlogCatalogueDTO;
import com.groot.blog.entity.BlogCatalogue;
import com.groot.blog.service.BlogCatalogueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客目录
 */
@RestController
@RequestMapping(value = "catalogue")
public class BlogCatalogueController {

    @Resource
    private BlogCatalogueService blogCatalogueService;
    @Resource
    private BlogCatalogueConvertor blogCatalogueConvertor;

    /**
     * 获取博客树形结构目录
     *
     * @param category 目录类别
     * @return 博客树形结构目录
     */
    @GetMapping(value = "{category}/getCatalogueTree")
    public ResultData<List<BlogCatalogueDTO>> getCatalogueTree(@PathVariable String category) {
        List<BlogCatalogueDTO> catalogueList = blogCatalogueService.getCatalogueTree(category);
        return ResultData.success("获取目录成功！", catalogueList);
    }

    /**
     * 创建目录
     *
     * @param blogCatalogueDTO 博客目录
     * @return 博客目录树形结构
     */
    @PostMapping(value = "createCatalogue")
    public ResultData<List<BlogCatalogueDTO>> createCatalogue(@RequestBody BlogCatalogueDTO blogCatalogueDTO) {
        BlogCatalogue blogCatalogue = blogCatalogueConvertor.toEntity(blogCatalogueDTO);
        blogCatalogueService.createCatalogue(blogCatalogue);
        List<BlogCatalogueDTO> catalogueTree = blogCatalogueService.getCatalogueTree(blogCatalogue.getCategory());
        return ResultData.success("保存成功！", catalogueTree);
    }
}
