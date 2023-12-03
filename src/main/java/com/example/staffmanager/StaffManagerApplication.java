package com.example.staffmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.staffmanager.demos.mapper")
@SpringBootApplication
public class StaffManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffManagerApplication.class, args);
    }

}
