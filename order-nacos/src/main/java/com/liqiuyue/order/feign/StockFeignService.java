package com.liqiuyue.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * name 指定调用rest接口所对应的服务名
 * path 指定调用rest接口所在的StockController指定的@RequestMapping
 *
 * 底层：动态代理
 * @author liqiuyue
 */
@FeignClient(name = "stock-service",path = "/stock")
//@FeignClient(name = "stock-service",path = "/stock" ,configuration = FeignConfig.class)
public interface StockFeignService {

    @GetMapping("/reduce")
    String reduce();


}
