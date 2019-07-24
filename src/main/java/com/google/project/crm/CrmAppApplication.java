package com.google.project.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.google.project.crm.dao"})
public class CrmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmAppApplication.class, args);
	}

}
