package com.todoautos.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Rol;
import com.todoautos.usuarios.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    // Creación de rol con validaciones básicas
    public Rol crearRol(Rol rol) {
        if (rol == null) {
            throw new RuntimeException("Error: El objeto enviado es nulo.");
        }
        // Recomendación: aquí podrías agregar lógica para verificar si el nombre del rol ya existe
        return rolRepository.save(rol);
    }

    public List<Rol> listarRoles() {
        List<Rol> roles = rolRepository.findAll();
        if (roles.isEmpty()) {
            throw new RuntimeException("No existen roles registrados en el sistema.");
        }
        return roles;
    }

    public Rol buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID proporcionado no es válido.");
        }
        return rolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol con ID: " + id));
    }

    public void eliminarRol(Integer id) {
    // Validación de entrada
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID proporcionado no es válido.");
        }

        // Validación de existencia
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Error: No se pudo eliminar porque el rol con ID " + id + " no existe.");
        }

        rolRepository.deleteById(id);
    }

    public Rol actualizarRol(Rol rol) {
        if (rol == null || rol.getIdRol() == null) {
            throw new RuntimeException("Rol o ID no pueden ser nulos");
        }

        Rol rolExistente = rolRepository.findById(rol.getIdRol())
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Actualizamos campos simples
        rolExistente.setNombreRol(rol.getNombreRol());

        // ACTUALIZACIÓN DE LISTA (La parte importante)
        // Limpiamos la lista actual y agregamos los nuevos permisos
        rolExistente.getPermisos().clear();
        rolExistente.getPermisos().addAll(rol.getPermisos());

        return rolRepository.save(rolExistente);
    }
}