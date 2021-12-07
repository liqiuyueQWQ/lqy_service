package com.lqy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * config启动类
 *
 * @ClassName: ConfigApplication
 * @Author: liqiuyue
 * @Date: 2021-12-06
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String userName = environment.getProperty("user.name");
        String age = environment.getProperty("user.age");
        System.out.println("user name:" + userName + "----->age:" + age);
    }

}
