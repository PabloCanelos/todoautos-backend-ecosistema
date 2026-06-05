package com.todoautos.proveedores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoautos.proveedores.entity.DetalleCompra;
import com.todoautos.proveedores.service.DetalleCompraService;

@RestController
@RequestMapping("/api/detalles")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping("/listar")
    public List<DetalleCompra> listarDetalles(){
        return detalleCompraService.listarDetalles();
    }

    @PostMapping
    public DetalleCompra crearDetalle(@RequestBody DetalleCompra detalle){
        return detalleCompraService.crearDetalle(detalle);
    }
    // Buscar por ID
    @GetMapping("/{id}")
    public DetalleCompra buscarPorId(@PathVariable Integer id) {
        return detalleCompraService.buscarPorId(id);
    }

    // Actualizar por ID
    @PutMapping("/{id}")
    public DetalleCompra actualizarDetalle(@PathVariable Integer id,
                                           @RequestBody DetalleCompra detalle) {
        detalle.setIdDetalleCompra(id);
        return detalleCompraService.actualizarDetalle(detalle);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void eliminarDetalle(@PathVariable Integer id) {
        detalleCompraService.eliminarDetalle(id);
    }
}
