package com.todoautos.proveedores.service;

import com.todoautos.proveedores.entity.OrdenCompra;
import com.todoautos.proveedores.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public List<OrdenCompra> obtenerOrdenes(){
        return ordenCompraRepository.findAll();
    }

    public OrdenCompra guardarOrden(OrdenCompra orden){
        if (orden == null) {
            throw new RuntimeException("Error: El objeto de orden no puede ser nulo.");
        }
        return ordenCompraRepository.save(orden);
    }
}