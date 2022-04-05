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
    @PostMapping(value = "editCatalogue")
    public ResultData<List<BlogCatalogueDTO>> editCatalogue(@RequestBody BlogCatalogueDTO blogCatalogueDTO) {
        BlogCatalogue blogCatalogue = blogCatalogueConvertor.toEntity(blogCatalogueDTO);
        blogCatalogueService.editCatalogue(blogCatalogue);
        List<BlogCatalogueDTO> catalogueTree = blogCatalogueService.getCatalogueTree(blogCatalogue.getCategory());
        return ResultData.success("保存成功！", catalogueTree);
    }

    @DeleteMapping(value = "{category}/deleteByIdArr")
    public ResultData<List<BlogCatalogueDTO>> deleteByIdArr(@PathVariable String category,
                                                            @RequestParam String[] idArr) {
        blogCatalogueService.deleteByIdArr(idArr);
        List<BlogCatalogueDTO> catalogueTree = blogCatalogueService.getCatalogueTree(category);
        return ResultData.success("删除成功！", catalogueTree);
    }

    @GetMapping(value = "getNewest")
    public ResultData<List<BlogCatalogueDTO>> getNewest(@RequestParam(required = false) String category) {
        List<BlogCatalogue> blogCatalogues = blogCatalogueService.getNewest(category);
        List<BlogCatalogueDTO> blogCatalogueDTOs = blogCatalogueConvertor.toListDTO(blogCatalogues);
        return ResultData.success("获取最新编辑的文章成功！", blogCatalogueDTOs);
    }

    @GetMapping(value = "{id}/getById")
    public ResultData<BlogCatalogueDTO> getById(@PathVariable String id) {
        BlogCatalogue blogCatalogue = blogCatalogueService.getById(id);
        BlogCatalogueDTO blogCatalogueDTO = blogCatalogueConvertor.toDTO(blogCatalogue);
        return ResultData.success("根据id获取目录信息成功！", blogCatalogueDTO);
    }

}
