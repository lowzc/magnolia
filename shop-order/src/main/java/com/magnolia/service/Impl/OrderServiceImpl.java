package com.magnolia.service.Impl;

import com.magnolia.dao.OrderDao;
import com.magnolia.service.OrderService;
import com.magnolia.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *@author matas
 *@date  2020/9/6 17:14
 *@email   mataszhang@163.com
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }
}
