package com.configuracion_stock;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDiscoveryClient
@SpringBootApplication
public class MsConfiguracionStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConfiguracionStockApplication.class, args);
	}

}
//microservicio corriendo de manera correcta
