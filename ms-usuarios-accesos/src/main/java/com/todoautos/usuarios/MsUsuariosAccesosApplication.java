package com.todoautos.usuarios;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class MsUsuariosAccesosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsuariosAccesosApplication.class, args);
	}

}
//MICROSERVICIO CORREINDO CORRECTAMENTE