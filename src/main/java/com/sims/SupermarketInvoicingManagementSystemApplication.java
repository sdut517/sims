package com.sims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sims.dao")
@SpringBootApplication
public class SupermarketInvoicingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarketInvoicingManagementSystemApplication.class, args);
    }

}
