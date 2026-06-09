package com.todoautos.usuarios.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Permiso;
import com.todoautos.usuarios.repository.PermisoRepository;
import com.todoautos.usuarios.util.utilValidaciones.DataValidator;

@Service
public class PermisoService {

    @Autowired
    public PermisoRepository permisoRepository;

    @Autowired
    private DataValidator validator;

    // --- MÉTODOS DE CREACIÓN Y ACTUALIZACIÓN ---

    public Permiso crearPermiso(Permiso permiso) {
        if (permiso == null) throw new RuntimeException("El objeto no existe, o es nulo");

        limpiarDatos(permiso);
        validator.validateFormatName(permiso.getNombrePermiso(), "Nombre del Permiso");
        validator.validateDescription(permiso.getDescripcionPermiso(), 10, 255);

        if (permisoRepository.findByNombrePermiso(permiso.getNombrePermiso()).isPresent()) {
            throw new RuntimeException("Error: El permiso '" + permiso.getNombrePermiso() + "' ya existe.");
        }

        return permisoRepository.save(permiso);
    }

    public Permiso actualizarPermiso(Permiso permiso) {
        if (permiso == null || permiso.getIdPermiso() == null) {
            throw new RuntimeException("El permiso o su ID no pueden ser nulos");
        }

        Permiso existente = permisoRepository.findById(permiso.getIdPermiso())
            .orElseThrow(() -> new RuntimeException("No se encontró el permiso con ID: " + permiso.getIdPermiso()));

        limpiarDatos(permiso);
        validator.validateFormatName(permiso.getNombrePermiso(), "Nombre del Permiso");
        validator.validateDescription(permiso.getDescripcionPermiso(), 10, 255);

        if (!existente.getNombrePermiso().equalsIgnoreCase(permiso.getNombrePermiso())) {
            if (permisoRepository.findByNombrePermiso(permiso.getNombrePermiso()).isPresent()) {
                throw new RuntimeException("Error: Ya existe otro permiso con el nombre '" + permiso.getNombrePermiso() + "'.");
            }
        }

        existente.setNombrePermiso(permiso.getNombrePermiso());
        existente.setDescripcionPermiso(permiso.getDescripcionPermiso());

        return permisoRepository.save(existente);
    }

    // --- MÉTODOS DE LECTURA ---

    public Permiso buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID del permiso no es válido.");
        }
        return permisoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: Permiso con ID " + id + " no encontrado."));
    }

    public List<Permiso> listarPermisos() {
        List<Permiso> lista = permisoRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("No hay permisos registrados en el sistema.");
        }
        return lista;
    }

    // --- MÉTODO DE ELIMINACIÓN ---

    public void eliminarPermiso(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID para eliminar no es válido.");
        }
        if (!permisoRepository.existsById(id)) {
            throw new RuntimeException("Error: No se pudo eliminar, el permiso con ID " + id + " no existe.");
        }
        permisoRepository.deleteById(id);
    }

    // --- MÉTODO AUXILIAR ---

    private void limpiarDatos(Permiso p) {
        if (p.getNombrePermiso() != null) p.setNombrePermiso(p.getNombrePermiso().trim());
        if (p.getDescripcionPermiso() != null) p.setDescripcionPermiso(p.getDescripcionPermiso().trim());
    }
}