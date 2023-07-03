package com.huimu.flowerplant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.huimu.flowerplant.*.dao", "com.baidu.fsg"})
@SpringBootApplication
public class FlowerplantApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowerplantApplication.class, args);
	}

}
