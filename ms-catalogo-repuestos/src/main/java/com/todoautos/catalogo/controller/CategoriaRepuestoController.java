package com.todoautos.catalogo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoautos.catalogo.entity.CategoriaRepuesto;
import com.todoautos.catalogo.service.CategoriaRepuestoService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaRepuestoController {

    @Autowired
    private CategoriaRepuestoService categoriaService;

    // 1. AGREGAR
    @PostMapping("/agregar")
    public ResponseEntity<?> guardarCategoria(@RequestBody CategoriaRepuesto categoria) {
        try {
            CategoriaRepuesto categoriaGuardada = categoriaService.guardarCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaGuardada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 2. BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            CategoriaRepuesto categoria = categoriaService.buscarPorId(id);
            return ResponseEntity.ok(categoria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaRepuesto>> listarTodo() {
        List<CategoriaRepuesto> lista = categoriaService.listarTodo();
        return ResponseEntity.ok(lista);
    }

    // 4. ACTUALIZAR
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarCategoria(@RequestBody CategoriaRepuesto categoria) {
        try {
            CategoriaRepuesto actualizada = categoriaService.actualizarCategoria(categoria);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 5. ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id) {
        try {
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.ok("Categoría eliminada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}