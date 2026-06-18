package com.todoautos.proveedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MsGestionProveedoresApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGestionProveedoresApplication.class, args);
    }

}
//MICRO SERVICIO CORREINDO CORRECTAMENTE AUN SIN RELACIONES PERO NO HA FALLADO