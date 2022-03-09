package com.groot.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.groot.blog.entity.BlogContent;
import com.groot.blog.mapper.BlogContentMapper;
import com.groot.blog.service.BlogContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BlogContentServiceImpl implements BlogContentService {
    @Resource
    private BlogContentMapper blogContentMapper;

    @Override
    public BlogContent getByFileId(String fileId) {
        QueryWrapper<BlogContent> wrapper = new QueryWrapper<>();
        wrapper.eq("file_id", fileId);
        return blogContentMapper.selectOne(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BlogContent updateText(BlogContent blogContent) {
        blogContentMapper.updateById(blogContent);
        return blogContent;
    }
}
