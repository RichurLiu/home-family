package com.home.family;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author richur
 */
@SpringBootApplication
@MapperScan(value = "com.home.family.dal.mapper")
public class HomeFamilyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeFamilyApplication.class, args);
    }

}
