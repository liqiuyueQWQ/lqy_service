package com.liqiuyue.order.config;

import com.liqiuyue.order.interceptor.feign.CustomerFeignInterceptor;
import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FeignConfig
 * @Description: feign配置类
 * @Author: liqiuyue
 * @Date: 2021-11-18
 *
 * 全局配置：使用@Configuration注解，会将配置作用所有的服务提供方
 * 局部配置： 不使用注解 针对某个服务
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

//    @Bean
//    public Contract feignContract(){
//        return new Contract.Default();
//    }

//    @Bean
//    public CustomerFeignInterceptor feignInterceptor(){
//        return new CustomerFeignInterceptor();
//    }

}
