package com.todoautos.proveedores.controller;

import com.todoautos.proveedores.entity.Proveedor;
import com.todoautos.proveedores.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Listar todos
    @GetMapping
    public List<Proveedor> listarProveedores() {
        return proveedorService.obtenerProveedores();
    }

    // Crear nuevo
    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Proveedor buscarPorId(@PathVariable Integer id) {
        return proveedorService.buscarPorId(id);
    }

    // Actualizar por ID
    @PutMapping("/{id}")
    public Proveedor actualizarProveedor(@RequestBody Proveedor proveedor) {

        return proveedorService.actualizarProveedor(proveedor);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable Integer id) {
        proveedorService.eliminarProveedor(id);
    }
}
