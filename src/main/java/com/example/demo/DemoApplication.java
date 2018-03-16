package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.run.Dao")  //扫描Dao层
public class DemoApplication {
//启动文件
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
