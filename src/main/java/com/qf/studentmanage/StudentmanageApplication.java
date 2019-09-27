package com.qf.studentmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
public class StudentmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmanageApplication.class, args);
    }

}
