package com.liqiuyue.order.controller;

import com.liqiuyue.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderController
 * @Description: 订单
 * @Author: liqiuyue
 * @Date: 2021-07-17
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockFeignService stockFeignService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String reduce = stockFeignService.reduce();
        return reduce;
    }
}
