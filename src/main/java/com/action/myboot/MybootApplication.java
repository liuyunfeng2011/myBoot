package com.action.myboot;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.action.myboot"})
//定义JPA接口扫描包路径
@EnableJpaRepositories(basePackages = "com.action.myboot.dao")
//定义实体Bean扫描包路径
@EntityScan(basePackages = "com.action.myboot.pojo")

public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}
	
}
