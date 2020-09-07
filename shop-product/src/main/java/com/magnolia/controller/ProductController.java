package com.magnolia.controller;


import com.alibaba.fastjson.JSON;
import com.magnolia.service.ProductService;
import com.magnolia.domain.Product;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ProductController {

    @Resource
    private  ProductService productService;

    //商品信息查询
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid){
        log.debug("获取到商品的id为："+ pid);
        Product product = productService.findByPid(pid);
        log.debug("获取商品信息为，{}" + JSON.toJSONString(product));
        return  product;
    }
}
