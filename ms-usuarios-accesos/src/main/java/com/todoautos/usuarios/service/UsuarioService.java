package com.todoautos.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Usuario;
import com.todoautos.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario agregarUsuario(Usuario user) {
        // Validación de datos básicos antes de guardar
        if (user == null) {
            throw new RuntimeException("Error: El usuario no puede ser nulo.");
        }
        if (user.getNombreUsuario() == null || user.getNombreUsuario().isEmpty()) {
            throw new RuntimeException("Error: El nombre de usuario es obligatorio.");
        }

        return usuarioRepository.save(user);
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = usuarioRepository.findAll();

        // Validación de lista vacía
        if (lista.isEmpty()) {
            throw new RuntimeException("No hay usuarios registrados en el sistema.");
        }

        return lista;
    }

    public Usuario buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID solicitado no es válido.");
        }

        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: Usuario con ID " + id + " no encontrado."));
    }

    public Usuario actualizarUsuario(Usuario user) {
        if (user == null || user.getIdUsuario() == null) {
            throw new RuntimeException("Error: El usuario o su ID no pueden ser nulos.");
        }

        // Verificamos existencia antes de intentar actualizar
        Usuario usuarioExistente = usuarioRepository.findById(user.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Error: No se encontró el usuario con ID: " + user.getIdUsuario()));

        // Mapeo de campos
        usuarioExistente.setNombreUsuario(user.getNombreUsuario());
        usuarioExistente.setContraseñaUsuario(user.getContraseñaUsuario());
        usuarioExistente.setRol(user.getRol());

        return usuarioRepository.save(usuarioExistente);
    }

    public void eliminarUsuario(Integer id) {
        if (id == null || !usuarioRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede eliminar, el usuario con ID " + id + " no existe.");
        }
        usuarioRepository.deleteById(id);
    }
}