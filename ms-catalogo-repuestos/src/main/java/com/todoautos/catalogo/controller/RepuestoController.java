package com.todoautos.catalogo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoautos.catalogo.entity.Repuesto;
import com.todoautos.catalogo.service.RepuestoService;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    // --- CREATE ---
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Repuesto repuesto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(repuestoService.crearRepuesto(repuesto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // --- READ (Uno) ---
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(repuestoService.buscarPorId(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // --- READ (Todos) ---
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        try {
            List<Repuesto> lista = repuestoService.listarRepuestos();
            return ResponseEntity.ok(lista);
        } catch (java.util.NoSuchElementException e) {
            // Esta es la excepción que lanzas cuando la lista está vacía
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            // Esto captura CUALQUIER otro error, incluyendo el de serialización (Jackson)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error técnico: " + e.getMessage());
        }
    }

    // --- UPDATE ---
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Repuesto repuesto) {
        try {
            return ResponseEntity.ok(repuestoService.actualizarRepuesto(repuesto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // --- DELETE ---
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            repuestoService.eliminarRepuesto(id);
            return ResponseEntity.ok("Repuesto con ID " + id + " eliminado correctamente.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}