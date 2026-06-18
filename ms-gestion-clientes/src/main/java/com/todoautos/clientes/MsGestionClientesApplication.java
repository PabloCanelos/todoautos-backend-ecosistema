package com.todoautos.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsGestionClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionClientesApplication.class, args);
	}

}
//micro servicio corriendo correctamente