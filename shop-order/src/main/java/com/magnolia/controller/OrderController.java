package com.magnolia.controller;


import com.alibaba.fastjson.JSON;
import com.magnolia.domain.Order;
import com.magnolia.domain.Product;
import com.magnolia.service.Impl.ProductService;
import com.magnolia.service.OrderService;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductService productService;

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.debug("接收到的商品id为{}", pid);
        //从nacos中获取服务地址
        ServiceInstance serviceInstance =
                discoveryClient.getInstances("service-product").get(0);
        String url = serviceInstance.getHost() + ":" +
                serviceInstance.getPort();

        Product product = productService.findByPid(pid);
        //Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);
        log.info("得到的商品信息为{}", JSON.toJSONString(product));
        Order order = new Order();
        order.setPid(pid);
        order.setNumber(1);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setUsername("测试用户");
        order.setUid(1);
        orderService.createOrder(order);
        log.debug("下单成功");
        return order;
    }




//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.debug("接收到的商品id为{}", pid);
//        //从nacos中获取服务地址
//        ServiceInstance serviceInstance =
//                discoveryClient.getInstances("service-product").get(0);
//        String url = serviceInstance.getHost() + ":" +
//                serviceInstance.getPort();
//        log.info("获取到的url{}", url);
//
//        Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);
//        Order order = new Order();
//        order.setPid(pid);
//        order.setNumber(1);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setUsername("测试用户");
//        order.setUid(1);
//        orderService.createOrder(order);
//        log.debug("下单成功");
//        return order;
//    }


//    //下单
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid){
//        log.debug("接收到的商品id为{}",pid);
//        Product product = restTemplate.getForObject("http://localhost:8081/product/"+pid, Product.class);
//        Order order = new Order();
//        order.setPid(pid);
//        order.setNumber(1);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setUsername("测试用户");
//        order.setUid(1);
//        orderService.createOrder(order);
//        log.debug("下单成功");
//        return order;
//    }
}
