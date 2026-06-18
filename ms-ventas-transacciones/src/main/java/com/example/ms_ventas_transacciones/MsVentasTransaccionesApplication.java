package com.example.ms_ventas_transacciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MsVentasTransaccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVentasTransaccionesApplication.class, args);
	}


}
//microservicio corriendo correctamente