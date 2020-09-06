package com.magnolia.service.Impl;

import com.magnolia.dao.ProductDao;
import com.magnolia.service.ProductService;
import com.magnolia.domain.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 *@author matas
 *@date  2020/9/6 17:35
 *@email   mataszhang@163.com
 */
@Service
public class ProductServiceImpl  implements ProductService {

    @Resource
    ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

    @Override
    public void reduceInventory(Integer pid, Integer number) {

    }
}
