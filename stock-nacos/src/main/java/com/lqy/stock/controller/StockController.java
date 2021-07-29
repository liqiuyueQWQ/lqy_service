package com.lqy.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StockController
 * @Description: 库存
 * @Author: liqiuyue
 * @Date: 2021-07-17
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String port;

    @GetMapping("reduce")
    public String reduce(){
        System.out.println("扣减库存");
        return "扣减库存:" + port;
    }

}
