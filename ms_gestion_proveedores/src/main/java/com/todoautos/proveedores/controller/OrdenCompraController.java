package com.todoautos.proveedores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoautos.proveedores.entity.OrdenCompra;
import com.todoautos.proveedores.service.OrdenCompraService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public List<OrdenCompra> listarOrdenes(){
        return ordenCompraService.obtenerOrdenes();
    }

    @PostMapping
    public OrdenCompra crearOrden(@RequestBody OrdenCompra orden){
        return ordenCompraService.guardarOrden(orden);
    }
}

