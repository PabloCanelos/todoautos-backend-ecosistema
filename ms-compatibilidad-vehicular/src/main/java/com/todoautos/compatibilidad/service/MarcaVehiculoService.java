package com.todoautos.compatibilidad.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.compatibilidad.entity.MarcaVehiculo;
import com.todoautos.compatibilidad.repository.MarcaVehiculoRepository;

@Service
public class MarcaVehiculoService {

    @Autowired
    private MarcaVehiculoRepository marcaRepository;

    // 1. GUARDAR MARCA (Con validación de nombres y duplicados)
    public MarcaVehiculo guardarMarca(MarcaVehiculo marca) {
        // Validación: No permitir nombres nulos o solo espacios
        if (marca.getNombreMarcaVehiculo() == null || marca.getNombreMarcaVehiculo().trim().isEmpty()) {
            throw new RuntimeException("Error: El nombre de la marca de vehículo es obligatorio.");
        }

        // Validación de Duplicados (Requiere método en Repository)
        if (marcaRepository.existsByNombreMarcaVehiculo(marca.getNombreMarcaVehiculo().trim())) {
            throw new RuntimeException("Error: La marca '" + marca.getNombreMarcaVehiculo() + "' ya existe.");
        }

        return marcaRepository.save(marca);
    }

    // 2. LISTAR TODO (Validar si hay datos )
    public List<MarcaVehiculo> listarTodo() {
        List<MarcaVehiculo> lista = marcaRepository.findAll();
        if (lista == null || lista.isEmpty()) {
            throw new RuntimeException("No se encontraron marcas de vehículos registradas.");
        }
        return lista;
    }

    // 3. BUSCAR POR ID (Blindaje de ID)
    public MarcaVehiculo buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID " + id + " no es un identificador válido.");
        }
        return marcaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: La marca con ID " + id + " no existe en la base de datos."));
    }
    // 4. ACTUALIZAR (Sin conflictos de variables)
    public MarcaVehiculo actualizarMarca(MarcaVehiculo marca) {

        if (marca.getIdMarcaVehiculo() == null) {
            throw new RuntimeException("Error: El ID de la marca es necesario para actualizar.");
        }

        if (marca.getNombreMarcaVehiculo() == null || marca.getNombreMarcaVehiculo().trim().isEmpty()) {
            throw new RuntimeException("Error: El nombre de la marca no puede quedar vacío.");
        }
        return marcaRepository.save(marca);
    }



    // 5. ELIMINAR (Con protección de integridad)
    public void eliminarMarca(Integer id) {
        if (id == null || !marcaRepository.existsById(id)) {
            throw new RuntimeException("Error: El ID " + id + " no existe, no se puede eliminar.");
        }

        try {
            marcaRepository.deleteById(id);
        } catch (Exception e) {
            // Si tiene modelos asociados, la base de datos saltará aquí
            throw new RuntimeException("Error: No se puede eliminar la marca porque tiene modelos vinculados en el sistema.");
        }
    }
}