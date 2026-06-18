package com.example.ms_movimientos_inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MsMovimientosInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMovimientosInventarioApplication.class, args);
	}

}
//MICRO SERVICIO CORRIENDO CORRECTAMENTE