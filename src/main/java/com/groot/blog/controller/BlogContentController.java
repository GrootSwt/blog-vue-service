package com.groot.blog.controller;

import com.groot.blog.base.bean.ResultData;
import com.groot.blog.convertor.BlogContentConvertor;
import com.groot.blog.dto.BlogContentDTO;
import com.groot.blog.entity.BlogContent;
import com.groot.blog.service.BlogContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "content")
public class BlogContentController {

    @Resource
    private BlogContentService blogContentService;
    @Resource
    private BlogContentConvertor blogContentConvertor;

    @GetMapping(value = "{fileId}/getByFileId")
    public ResultData<BlogContentDTO> getByFileId(@PathVariable String fileId) {
        BlogContent content = blogContentService.getByFileId(fileId);
        BlogContentDTO dto = blogContentConvertor.toDTO(content);
        return ResultData.success("获取文章内容成功！", dto);
    }

    @PutMapping(value = "updateText")
    public ResultData<BlogContentDTO> updateText(@RequestBody BlogContentDTO dto) {
        BlogContent blogContent = blogContentConvertor.toEntity(dto);
        blogContent = blogContentService.updateText(blogContent);
        dto = blogContentConvertor.toDTO(blogContent);
        return ResultData.success("保存文章内容成功！", dto);
    }
}
