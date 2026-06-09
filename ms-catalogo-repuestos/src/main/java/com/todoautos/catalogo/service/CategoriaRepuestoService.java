package com.todoautos.catalogo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.catalogo.entity.CategoriaRepuesto;
import com.todoautos.catalogo.entity.Repuesto;
import com.todoautos.catalogo.repository.CategoriaRepuestoRepository;

@Service
public class CategoriaRepuestoService {

    @Autowired
    private CategoriaRepuestoRepository categoriaRepository;

    public CategoriaRepuesto guardarCategoria(CategoriaRepuesto categoria) {
    if (categoria == null) throw new IllegalArgumentException("La categoría no puede ser nula.");

    // AQUÍ ESTÁ EL TRUCO:
    // Si vienen repuestos en la lista, debemos asignar manualmente la categoría
    // a cada uno para satisfacer la restricción @JoinColumn(nullable = false)
    if (categoria.getRepuestos() != null && !categoria.getRepuestos().isEmpty()) {
        for (Repuesto repuesto : categoria.getRepuestos()) {
            repuesto.setCategoria(categoria);
        }
    }

        return categoriaRepository.save(categoria);
    }
    public CategoriaRepuesto buscarPorId(Integer id) {
    // 1. Error de validación: El ID no cumple con el formato requerido (400 Bad Request)
    if (id == null || id <= 0) {
        throw new IllegalArgumentException("El ID proporcionado (" + id + ") no es válido. Debe ser un número mayor a cero.");
    }

    // 2. Error de negocio/datos: El ID es válido pero no existe en la base (404 Not Found)
    return categoriaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró ninguna categoría con el ID: " + id));
    }


    public CategoriaRepuesto actualizarCategoria(CategoriaRepuesto categoria) {
        CategoriaRepuesto existente = buscarPorId(categoria.getIdCategoria());

        if (categoria.getDescripcion() == null || categoria.getDescripcion().isBlank()) {
            throw new IllegalArgumentException("La descripción es obligatoria.");
        }

        existente.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(existente);
    }
    public List<CategoriaRepuesto> listarTodo() {
    List<CategoriaRepuesto> lista = categoriaRepository.findAll();

    // Si la lista está vacía, lanzamos una excepción técnica
    if (lista.isEmpty()) {
        throw new RuntimeException("No existen categorías registradas actualmente.");
    }

        return lista;
    }
    // Método para eliminar
    public void eliminarCategoria(Integer id) {
        // Reusamos la búsqueda para validar existencia
        buscarPorId(id);
        categoriaRepository.deleteById(id);
    }
}