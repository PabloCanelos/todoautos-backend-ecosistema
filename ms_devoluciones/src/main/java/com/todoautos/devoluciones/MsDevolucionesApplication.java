package com.todoautos.devoluciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MsDevolucionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDevolucionesApplication.class, args);
	}

}
//microserviciocorriendo correctamente