package com.example.seckill;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.seckill.mapper")
public class SeckillDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SeckillDemo1Application.class, args);
	}


}
