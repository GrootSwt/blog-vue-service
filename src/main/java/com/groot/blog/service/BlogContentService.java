package com.groot.blog.service;

import com.groot.blog.entity.BlogContent;

public interface BlogContentService {
    BlogContent getByFileId(String fileId);

    BlogContent updateText(BlogContent blogContent);
}
