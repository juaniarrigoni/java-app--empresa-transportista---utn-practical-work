package com.tpi.catalogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogosApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogosApplication.class, args);
    }
}