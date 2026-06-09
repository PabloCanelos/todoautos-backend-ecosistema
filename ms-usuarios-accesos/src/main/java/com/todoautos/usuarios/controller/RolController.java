package com.todoautos.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoautos.usuarios.entity.Rol;
import com.todoautos.usuarios.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    // POST /api/roles
    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.crearRol(rol));
    }

    // GET /api/roles
    // GET /api/roles/listar
    @GetMapping("/listar")
    public ResponseEntity<?> listarRoles() {
        try {
            List<Rol> lista = rolService.listarRoles();
            return ResponseEntity.ok(lista);
        } catch (RuntimeException e) {
            // Devolvemos 404 Not Found si la lista está vacía
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/roles/1
    // GET /api/roles/1
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            Rol rol = rolService.buscarPorId(id);
            return ResponseEntity.ok(rol);
        } catch (RuntimeException e) {
            // Capturamos el error del Service y devolvemos un 404 claro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE /api/roles/1
    // DELETE /api/roles/1
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarRol(@PathVariable Integer id) {
        try {
            rolService.eliminarRol(id);
            return ResponseEntity.noContent().build(); // HTTP 204: Éxito sin cuerpo
        } catch (RuntimeException e) {
            // Capturamos el mensaje del Service y devolvemos 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // PUT /api/roles/1
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        rol.setIdRol(id); // Asegura consistencia
        return ResponseEntity.ok(rolService.actualizarRol(rol));
    }
}