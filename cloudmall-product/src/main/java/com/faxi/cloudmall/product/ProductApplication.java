package com.faxi.cloudmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date 2021-07-04 22:23
 */
@MapperScan("com.faxi.cloudmall.product.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.faxi.cloudmall.product.feign")
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
