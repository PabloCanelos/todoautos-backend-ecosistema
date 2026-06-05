package com.todoautos.proveedores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.proveedores.entity.DetalleCompra;
import com.todoautos.proveedores.repository.DetalleCompraRepository;
@Service
public class DetalleCompraService {
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    public List<DetalleCompra> listarDetalles(){
        return detalleCompraRepository.findAll();
    }


    public DetalleCompra crearDetalle(DetalleCompra detalle){
        if (detalle == null) {
            throw new RuntimeException("Error: El objeto de detalle no puede ser nulo.");
        }
        return detalleCompraRepository.save(detalle);
    }
    // Buscar por ID
    public DetalleCompra buscarPorId(Integer id) {
        if(id==null){
            throw new RuntimeException("ERROR: El id buscado no existe enla base de datos");
        }
        return detalleCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: El id " + id + " no existe en la base de datos."));
    }

    // Actualizar
    public DetalleCompra actualizarDetalle(DetalleCompra detalle) {
        if (detalle.getIdDetalleCompra() == null) {
            throw new RuntimeException("Error: El id no puede ser nulo para actualizar.");
        }
        return detalleCompraRepository.save(detalle);
    }

    // Eliminar
    public void eliminarDetalle(Integer id) {
        if (id ==null) {
            throw new RuntimeException("Error: El id " + id + " no existe en la base de datos.");
        }
        detalleCompraRepository.deleteById(id);
    }

}
