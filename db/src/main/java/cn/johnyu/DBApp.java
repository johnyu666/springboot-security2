package cn.johnyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.johnyu.mapper")
public class DBApp {
    public static void main(String[] args) {
        SpringApplication.run(DBApp.class,args);
    }
}
