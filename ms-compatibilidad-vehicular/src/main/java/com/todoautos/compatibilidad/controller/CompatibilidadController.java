package com.todoautos.compatibilidad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoautos.compatibilidad.entity.Compatibilidad;
import com.todoautos.compatibilidad.service.CompatibilidadService;

@RestController
@RequestMapping("/api/compatibilidad")
public class CompatibilidadController {

    @Autowired
    private CompatibilidadService compatibilidadService;

    // 1. LISTAR TODAS
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        try {
            List<Compatibilidad> lista = compatibilidadService.listarTodo();
            return ResponseEntity.ok(lista);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    // 2. BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            Compatibilidad encontrada = compatibilidadService.buscarPorId(id);
            return ResponseEntity.ok(encontrada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 3. REGISTRAR (Con validación de microservicio externo)
    
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Compatibilidad compatibilidad) {
        try {
            Compatibilidad guardada = compatibilidadService.registrarCompatibilidad(compatibilidad);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 4. ACTUALIZAR
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Compatibilidad compatibilidad) {
        try {
            Compatibilidad actualizada = compatibilidadService.actualizarCompatibilidad(compatibilidad);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 5. ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            compatibilidadService.eliminarCompatibilidad(id);
            return ResponseEntity.ok("Registro eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}