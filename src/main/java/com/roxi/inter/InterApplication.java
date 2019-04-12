package com.roxi.inter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Roxi酱
 */
@MapperScan("com.roxi.inter.mapper")
@ServletComponentScan //这是 filter 的注解 才能让filter 让 spring boot 管理
@SpringBootApplication
public class InterApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterApplication.class, args);
    }

}
