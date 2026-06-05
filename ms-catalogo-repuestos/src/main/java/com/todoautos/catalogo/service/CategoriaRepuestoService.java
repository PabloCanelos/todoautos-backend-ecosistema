package com.todoautos.catalogo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.catalogo.entity.CategoriaRepuesto;
import com.todoautos.catalogo.repository.CategoriaRepuestoRepository;

@Service
public class CategoriaRepuestoService {

    @Autowired
    private CategoriaRepuestoRepository categoriaRepository;

    // 1. AGREGAR
    public CategoriaRepuesto guardarCategoria(CategoriaRepuesto categoria) {
        if (categoria == null) {
            throw new RuntimeException("Error: El objeto Categoria no puede ser nulo.");
        }

        return categoriaRepository.save(categoria);
    }

    // 2. BUSCAR POR ID
    public CategoriaRepuesto buscarPorId(Integer id) {
        if (id == null) {
             throw new RuntimeException("Error: El ID de la categoría no puede ser nulo.");
        }
        if (id <= 0) {
            throw new RuntimeException("Error: El ID proporcionado (" + id + ") no es válido. Debe ser un número mayor a cero.");
        }
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Error: No se encontró ninguna categoría con el ID: " + id));
    }

    // 3. LISTAR 
    public List<CategoriaRepuesto> listarTodo() {
        return categoriaRepository.findAll();
    }

    // 4. ACTUALIZAR
    public CategoriaRepuesto actualizarCategoria(CategoriaRepuesto categoria) {
        if (categoria == null) {
            throw new RuntimeException("Error: El objeto categoría no puede ser nulo.");
        }

        Integer id = categoria.getIdCategoria();
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: Para actualizar se requiere una categoría con un ID válido y mayor a cero.");
        }
        if (categoria.getDescripcion() == null || categoria.getDescripcion().trim().isEmpty()) {
            throw new RuntimeException("Error: La descripción es obligatoria para actualizar.");
        }
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede actualizar. La categoría con el ID: " + id + " no existe.");
        }
        return categoriaRepository.save(categoria);
    }

    // 5. ELIMINAR
    public void eliminarCategoria(Integer id) {
        if (id == null) {
            throw new RuntimeException("Error: Para eliminar una categoría debe ingresar un ID. El ID no puede quedar vacío.");
        }
        if (id <= 0) {
            throw new RuntimeException("Error: El ID no puede ser menor o igual a cero.");
        }
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede eliminar. La categoría con el ID: " + id + " no existe.");
        }
        categoriaRepository.deleteById(id);
    }
}