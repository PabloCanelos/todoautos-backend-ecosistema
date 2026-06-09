package com.todoautos.catalogo.controller;
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

    @PostMapping("/agregar")
    public ResponseEntity<CategoriaRepuesto> guardarCategoria(@RequestBody CategoriaRepuesto categoria) {
        // Sin try-catch, el GlobalExceptionHandler se encarga de los errores
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.guardarCategoria(categoria));
    }

    @GetMapping("/buscar/{id}")
public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
    try {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    } catch (IllegalArgumentException e) {
        // Esto captura los IDs inválidos (ej: -1, 0)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (RuntimeException e) {
        // Esto captura cuando el ID no existe en la base de datos
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

    @GetMapping("/listar")
    public ResponseEntity<?> listarTodo() {
        try {
            return ResponseEntity.ok(categoriaService.listarTodo());
        } catch (RuntimeException e) {
            // Retornamos 404 porque no se encontraron recursos
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CategoriaRepuesto> actualizarCategoria(@RequestBody CategoriaRepuesto categoria) {
        return ResponseEntity.ok(categoriaService.actualizarCategoria(categoria));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer id) {
        try {
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.ok("Categoría eliminada correctamente.");
        } catch (RuntimeException e) {
            // En lugar de un 500, devolvemos un 404 Not Found con el mensaje de tu Service
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}