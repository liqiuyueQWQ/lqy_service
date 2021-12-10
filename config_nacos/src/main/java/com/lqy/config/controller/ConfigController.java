package com.lqy.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * config
 *
 * @ClassName: ConfigController
 * @Author: liqiuyue
 * @Date: 2021-12-10
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${user.name}")
    public String userName;

    @GetMapping("/value")
    public String getUserName(){
        return userName;
    }

}
