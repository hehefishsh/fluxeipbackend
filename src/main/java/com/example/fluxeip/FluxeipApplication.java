package com.example.fluxeip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxeipApplication {

    public static void main(String[] args) {
        // 直接從環境變數中讀取，而不是從 .env 檔案
        String username = System.getenv("username.email");
        String password = System.getenv("password");
        
        // 設置系統屬性（如果需要）
        System.setProperty("username", username);
        System.setProperty("password", password);
        
        SpringApplication.run(FluxeipApplication.class, args);
    }

}
