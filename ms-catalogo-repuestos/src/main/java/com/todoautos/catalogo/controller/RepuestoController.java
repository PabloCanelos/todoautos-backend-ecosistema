package com.todoautos.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoautos.catalogo.entity.Repuesto;
import com.todoautos.catalogo.service.RepuestoService;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {
    @Autowired
    private RepuestoService repuestoService;


     // Endpoint para crear un nuevo repuesto
    // @PostMapping("/crear")
    // public ResponseEntity<?>crear(@RequestBody Repuesto repuesto) {
    //     try {
    //         Repuesto nuevoRepuesto= repuestoService.crearRepuesto(repuesto);
    //         return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRepuesto);
    //     } catch (RuntimeException e) {
    //         //si existe algu nulo
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    //     }
    // }
    // Endpoint para buscar un repuesto específico
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            Repuesto repuestoEncontrado = repuestoService.buscarPorId(id);
            return ResponseEntity.ok(repuestoEncontrado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }
    // Endpoint para listar todos los repuestos
    @GetMapping("/listar")
    public ResponseEntity<?>listar() {
        try {
            List<Repuesto>listaCompleta= repuestoService.listarRepuestos();
            return ResponseEntity.ok(listaCompleta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }




    // Endpoint para actualizar
    // @PutMapping("/actualizar")
    // public ResponseEntity<?> actualizar(@RequestBody Repuesto repuesto) {
    //     try {
    //         Repuesto actualizado = repuestoService.actualizarRepuesto(repuesto);
    //         return ResponseEntity.ok(actualizado);
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    //     }
    // }

    // Endpoint para eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            repuestoService.eliminarRepuesto(id);
            return ResponseEntity.ok("Repuesto con ID " + id + " eliminado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
