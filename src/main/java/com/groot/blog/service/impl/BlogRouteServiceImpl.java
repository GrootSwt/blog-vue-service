package com.groot.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.groot.blog.convertor.BlogRouteConvertor;
import com.groot.blog.dto.BlogRouteDTO;
import com.groot.blog.entity.BlogRoute;
import com.groot.blog.mapper.BlogRouteMapper;
import com.groot.blog.service.BlogRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogRouteServiceImpl implements BlogRouteService {

    @Resource
    private BlogRouteMapper blogRouteMapper;
    @Resource
    private BlogRouteConvertor blogRouteConvertor;

    @Override
    public List<BlogRouteDTO> getRouteTree() {
        QueryWrapper<BlogRoute> wrapper = new QueryWrapper<>();
        List<BlogRoute> blogRouteList = blogRouteMapper.selectList(wrapper);
        List<BlogRouteDTO> blogRouteDTOList = blogRouteConvertor.toListDTO(blogRouteList);
        BlogRouteDTO blogRouteDTO = new BlogRouteDTO();
        listToTree(blogRouteDTO, blogRouteDTOList, "-1");
        return blogRouteDTO.getChildren();
    }

    private void listToTree(BlogRouteDTO dto, List<BlogRouteDTO> list, String parentId) {
        if (!list.isEmpty()) {
            List<BlogRouteDTO> children = new ArrayList<>();
            for (BlogRouteDTO item: list) {
                if (parentId.equals(item.getParentId())) {
                    children.add(item);
                    listToTree(item, list, item.getId());
                }
            }
            dto.setChildren(children);
        }
    }
}
