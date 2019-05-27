package com.vuelearn.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// 或者在mapper 上写上@mapper ，或者在 application.yml 中配置
@MapperScan("com.vuelearn.pro.mapper")
@EnableTransactionManagement
public class ProApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProApplication.class, args);
    }

}
