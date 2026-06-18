package com.todoautos.devoluciones.controller;

import com.todoautos.devoluciones.entity.Devolucion;
import com.todoautos.devoluciones.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService service;

    // Método principal para registrar devolución y gestionar stock
    @PostMapping
    public ResponseEntity<Devolucion> registrarDevolucion(@RequestBody Devolucion devolucion) {
        return ResponseEntity.ok(service.procesarDevolucion(devolucion));
    }

    @GetMapping
    public ResponseEntity<List<Devolucion>> listarTodas() {
        return ResponseEntity.ok(service.listarTodasLasDevoluciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarDevolucionPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminarDevolucion(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody Devolucion dev) {
        service.actualizarDevolucion(dev);
        return ResponseEntity.ok().build();
    }
}