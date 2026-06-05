package com.todoautos.compatibilidad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.compatibilidad.entity.ModeloVehiculo;
import com.todoautos.compatibilidad.repository.ModeloVehiculoRepository;

@Service
public class ModeloVehiculoService {
    @Autowired
    private ModeloVehiculoRepository modeloRepository;

    // 1. GUARDAR
    public ModeloVehiculo guardarModelo(ModeloVehiculo modelo) {
        if (modelo.getNombreModeloVehiculo() == null || modelo.getNombreModeloVehiculo().trim().isEmpty()) {
            throw new RuntimeException("Error: El nombre del modelo es obligatorio.");
        }


        return modeloRepository.save(modelo);
    }

    // 2. LISTAR TODO
    public List<ModeloVehiculo> listarTodo() {
        List<ModeloVehiculo> lista = modeloRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("No hay modelos registrados en el sistema.");
        }
        return lista;
    }

    // 3. BUSCAR POR ID
    public ModeloVehiculo buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID de modelo no es válido.");
        }
        return modeloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: Modelo con ID " + id + " no encontrado."));
    }

    // 4. ACTUALIZAR
    public ModeloVehiculo actualizarModelo(ModeloVehiculo modelo) {
        if (modelo == null || modelo.getIdModeloVehiculo() == null) {
            throw new RuntimeException("Error: Se requiere el ID del modelo para actualizar.");
        }


        if (modelo.getNombreModeloVehiculo() == null || modelo.getNombreModeloVehiculo().trim().isEmpty()) {
            throw new RuntimeException("Error: El nombre del modelo no puede quedar vacío.");
        }

        return modeloRepository.save(modelo);
    }

    // 5. ELIMINAR
    public void eliminarModelo(Integer id) {
        if (id == null || !modeloRepository.existsById(id)) {
            throw new RuntimeException("Error: No existe un modelo con ese ID para eliminar.");
        }
        try {
            modeloRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error: No se puede eliminar el modelo. Verifique si tiene versiones de motor asociadas.");
        }
    }
}