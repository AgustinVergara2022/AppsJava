package com.agustin.SistemaEmpleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.agustin.SistemaEmpleados")
public class SistemaEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEmpleadosApplication.class, args);
	}

}
