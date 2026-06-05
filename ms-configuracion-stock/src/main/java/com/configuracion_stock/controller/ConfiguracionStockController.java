package com.configuracion_stock.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.configuracion_stock.entity.ConfiguracionStockEntity;
import com.configuracion_stock.service.ConfiguracionService;

@RestController
@RequestMapping("/api/configuraciones-stock")
public class ConfiguracionStockController {

    @Autowired
    private ConfiguracionService configuracionService;

    // 1. AGREGAR
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarStock(@RequestBody ConfiguracionStockEntity nuevaConfig) {
        try {
            ConfiguracionStockEntity guardada = configuracionService.agregarStock(nuevaConfig);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 2. LISTAR TODAS
    @GetMapping("/listar")
    public ResponseEntity<List<ConfiguracionStockEntity>> listarConfiguraciones() {
        List<ConfiguracionStockEntity> lista = configuracionService.listarConfiguraciones();
        return ResponseEntity.ok(lista);
    }

    // 3. BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            ConfiguracionStockEntity config = configuracionService.buscarPorId(id);
            return ResponseEntity.ok(config);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 4. ACTUALIZAR
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarStock(@RequestBody ConfiguracionStockEntity configExistente) {
        try {
            ConfiguracionStockEntity actualizada = configuracionService.actualizarStock(configExistente);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 5. ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarConfiguracion(@PathVariable Integer id) {
        try {
            configuracionService.eliminarConfiguracion(id);
            return ResponseEntity.ok("Configuración de stock eliminada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
