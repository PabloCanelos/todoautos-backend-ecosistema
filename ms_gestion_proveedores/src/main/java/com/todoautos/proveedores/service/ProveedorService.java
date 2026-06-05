package com.todoautos.proveedores.service;

import com.todoautos.proveedores.entity.Proveedor;
import com.todoautos.proveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Listar todos
    public List<Proveedor> obtenerProveedores() {
        return proveedorRepository.findAll();
    }

    // Crear nuevo
    public Proveedor guardarProveedor(Proveedor proveedor) {
        if (proveedor == null) {
            throw new RuntimeException("Error: El proveedor no puede ser nulo.");
        }
        return proveedorRepository.save(proveedor);
    }

    // Buscar por ID
    public Proveedor buscarPorId(Integer id) {
        if(id==null){
            throw new RuntimeException("Error: El id no se encuentra registrado en la base de datos");
        }
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: El proveedor con id " + id + " no existe en la base de datos."));
    }

    // Actualizar
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        if(proveedor==null){
            throw new RuntimeException("ERROR: No se pudo actualizar");
        }
        return proveedorRepository.save(proveedor);
    }

    // Eliminar
    public void eliminarProveedor(Integer id) {
        if(id== null){
            throw new RuntimeException("Error: Id no encontrado");
        }
        proveedorRepository.deleteById(id);
    }
}
