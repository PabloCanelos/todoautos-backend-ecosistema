package com.todoautos.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.catalogo.entity.Repuesto;
import com.todoautos.catalogo.repository.RepuestoRepository;

@Service
public class RepuestoService {
    @Autowired
    private RepuestoRepository repuestoRepository;

    public Repuesto crearRepuesto(Repuesto repuesto) {
        // Validaciones de negocio (Bad Request)
        if (repuesto == null) throw new IllegalArgumentException("El objeto repuesto no puede ser nulo");
        if (repuesto.getNombreRepuesto() == null || repuesto.getNombreRepuesto().isBlank())
            throw new IllegalArgumentException("El nombre del repuesto es obligatorio");
        if (repuesto.getPrecioVentaRepuesto() == null || repuesto.getPrecioVentaRepuesto() < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo");
        if (repuesto.getCategoria() == null || repuesto.getCategoria().getIdCategoria() == null)
            throw new IllegalArgumentException("Debe asignar una categoría válida");

        return repuestoRepository.save(repuesto);
    }

    public Repuesto buscarPorId(Integer id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("ID inválido: " + id);

        // Excepción específica para cuando algo no se encuentra (Not Found)
        return repuestoRepository.findById(id)
            .orElseThrow(() -> new java.util.NoSuchElementException("Repuesto con ID " + id + " no encontrado"));
    }

    public List<Repuesto> listarRepuestos() {
        List<Repuesto> lista = repuestoRepository.findAll();
        if (lista.isEmpty()) throw new java.util.NoSuchElementException("No hay repuestos registrados");
        return lista;
    }

    public Repuesto actualizarRepuesto(Repuesto repuesto) {
        // Validación de existencia primero
        Repuesto existente = buscarPorId(repuesto.getIdRepuesto());

        // Validaciones de datos
        if (repuesto.getPrecioVentaRepuesto() != null && repuesto.getPrecioVentaRepuesto() < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo");

        // Actualización lógica
        existente.setNombreRepuesto(repuesto.getNombreRepuesto());
        existente.setPrecioVentaRepuesto(repuesto.getPrecioVentaRepuesto());
        // ... setear el resto de campos

        return repuestoRepository.save(existente);
    }

    public void eliminarRepuesto(Integer id) {
        if (!repuestoRepository.existsById(id)) {
            throw new java.util.NoSuchElementException("No se puede eliminar: ID " + id + " inexistente");
        }
        repuestoRepository.deleteById(id);
    }
}