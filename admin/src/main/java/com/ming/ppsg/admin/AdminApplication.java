package com.ming.ppsg.admin;

import com.ming.ppsg.tool.generate.Generate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(
    basePackages = {
        "com.ming.ppsg.admin",
        "com.ming.ppsg.ppsg",
    }
)
@MapperScan(basePackages = {
        "com.ming.ppsg.admin.mapper",
        "com.ming.ppsg.ppsg.mapper"
})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        try {
            Generate.getInstance().create(new String[]{"com.ming.ppsg.ppsg"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
