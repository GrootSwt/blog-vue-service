package com.groot.blog.service;

import com.groot.blog.dto.BlogRouteDTO;

import java.util.List;

public interface BlogRouteService {
    List<BlogRouteDTO> getRouteTree();
}
