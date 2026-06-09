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

import com.todoautos.usuarios.entity.Usuario;
import com.todoautos.usuarios.service.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // POST /api/usuarios/crear
    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.agregarUsuario(user));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        try {
            List<Usuario> lista = usuarioService.listarUsuario();
            return ResponseEntity.ok(lista);
        } catch (RuntimeException e) {
            // Aquí capturas el mensaje que lanzaste en el Service
            // y lo devuelves manualmente como un error 404 o 400
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/usuarios/1
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            Usuario usuario = usuarioService.buscarPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            // Al atrapar la excepción, evitas el error 500 y devuelves un 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // PUT /api/usuarios/1
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario user) {
        user.setIdUsuario(id); // Asegura que el ID del objeto coincida con la URL
        return ResponseEntity.ok(usuarioService.actualizarUsuario(user));
    }

    // DELETE /api/usuarios/1
    // 2. ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build(); // HTTP 204
        } catch (RuntimeException e) {
            // Devolvemos 404 Not Found cuando el ID no existe o es inválido
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}