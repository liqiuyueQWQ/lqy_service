package com.liqiuyue.order.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: CustomerFeignInterceptor
 * @Description: 用户拦截器
 * @Author: liqiuyue
 * @Date: 2021-11-18
 */
public class CustomerFeignInterceptor implements RequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.query("id", "1");
        logger.info("feign拦截器!");
    }


}
