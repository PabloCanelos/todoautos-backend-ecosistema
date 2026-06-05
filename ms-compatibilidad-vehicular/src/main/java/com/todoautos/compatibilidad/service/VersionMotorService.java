package com.todoautos.compatibilidad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.compatibilidad.entity.VersionMotor;
import com.todoautos.compatibilidad.repository.VersionMotorRepository;

@Service
public class VersionMotorService {

    @Autowired
    private VersionMotorRepository versionMotorRepository;

    // 1. GUARDAR
    public VersionMotor guardarVersion(VersionMotor versionMotor) {
        if (versionMotor.getDescripcionVersionMotor() == null || versionMotor.getDescripcionVersionMotor().trim().isEmpty()) {
            throw new RuntimeException("Error: La descripción del motor no puede estar vacía.");
        }

        return versionMotorRepository.save(versionMotor);
    }

    // 2. BUSCAR POR ID (Blindado)
    public VersionMotor buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: ID de motor no válido.");
        }
        return versionMotorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: La versión de motor con ID " + id + " no existe."));
    }

    // 3. LISTAR TODO
    public List<VersionMotor> listarTodo() {
        List<VersionMotor> lista = versionMotorRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("No hay versiones de motor registradas.");
        }
        return lista;
    }

    // 4. ACTUALIZAR
    public VersionMotor actualizarVersion(VersionMotor versionMotor) {
        if (versionMotor == null || versionMotor.getIdVersionMotor() == null) {
            throw new RuntimeException("Error: El ID es obligatorio para actualizar.");
        }


        if (versionMotor.getDescripcionVersionMotor() == null || versionMotor.getDescripcionVersionMotor().trim().isEmpty()) {
            throw new RuntimeException("Error: La descripción no puede quedar vacía.");
        }

        return versionMotorRepository.save(versionMotor);
    }

    // 5. ELIMINAR
    public void eliminarVersion(Integer id) {
        if (id == null || !versionMotorRepository.existsById(id)) {
            throw new RuntimeException("Error: El motor con ID " + id + " no existe.");
        }
        try {
            versionMotorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error: No se puede eliminar. Este motor tiene compatibilidades de repuestos asociadas.");
        }
    }
}