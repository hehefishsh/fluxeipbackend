package com.example.fluxeip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxeipApplication {

    public static void main(String[] args) {
        // 直接從系統環境變數中讀取資料庫帳密
		String username = System.getenv("USERNAME_EMAIL");
		String password = System.getenv("PASSWORD");
        
        // 設置系統屬性（如果需要）
        System.setProperty("username", username);
        System.setProperty("password", password);
        
        SpringApplication.run(FluxeipApplication.class, args);
    }

}
