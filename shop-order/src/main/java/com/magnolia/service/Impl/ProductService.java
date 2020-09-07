package com.magnolia.service.Impl;

import com.magnolia.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-product")//声明调用的提供者的name
public interface ProductService {

    @GetMapping(value = "/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);

}
