package com.groot.blog.controller;

import com.groot.blog.base.bean.ResultData;
import com.groot.blog.dto.BlogRouteDTO;
import com.groot.blog.service.BlogRouteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "route")
public class BlogRouteController {

    @Resource
    private BlogRouteService blogRouteService;

    @GetMapping(value = "getRouteTree")
    public ResultData<List<BlogRouteDTO>> getRouteTree() {
        List<BlogRouteDTO> blogRouteDTOList = blogRouteService.getRouteTree();
        return ResultData.success("获取路由成功！", blogRouteDTOList);
    }

}
