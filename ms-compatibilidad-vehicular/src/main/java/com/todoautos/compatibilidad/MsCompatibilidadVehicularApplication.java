package com.todoautos.compatibilidad;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDiscoveryClient
@SpringBootApplication
public class MsCompatibilidadVehicularApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCompatibilidadVehicularApplication.class, args);
	}

}

//microservicio corriendo correctamente