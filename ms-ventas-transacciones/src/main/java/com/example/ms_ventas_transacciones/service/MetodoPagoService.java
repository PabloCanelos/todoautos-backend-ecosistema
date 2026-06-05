package com.example.ms_ventas_transacciones.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_ventas_transacciones.model.MetodoPago;
import com.example.ms_ventas_transacciones.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    // 1. GUARDAR
    public MetodoPago guardarMetodoPago(MetodoPago metodoPago) {
        if (metodoPago == null) {
            throw new RuntimeException("Error: El objeto MetodoPago no puede ser nulo.");
        }
        return metodoPagoRepository.save(metodoPago);
    }

    // 2. LISTAR
    public List<MetodoPago> listarMetodoPago() {
        return metodoPagoRepository.findAll();
    }

    // 3. BUSCAR POR ID
    public MetodoPago buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID ingresado no es válido.");
        }
        return metodoPagoRepository.findById(id).orElse(null);
    }

    // 4. ACTUALIZAR 
    public MetodoPago actualizarMetodoPago(MetodoPago metodoPago) {
        if (metodoPago == null) {
            throw new RuntimeException("Error: El objeto MetodoPago no puede ser nulo.");
        }
        if (metodoPago.getIdMetodoPago() == null || metodoPago.getIdMetodoPago() <= 0) {
            throw new RuntimeException("Error: Se requiere un ID de método de pago válido para actualizar.");
        }
        if (!metodoPagoRepository.existsById(metodoPago.getIdMetodoPago())) {
            throw new RuntimeException("Error: El método de pago con ID " + metodoPago.getIdMetodoPago() + " no existe.");
        }
        return metodoPagoRepository.save(metodoPago);
    }

    // 5. ELIMINAR
    public void eliminarMetodoPago(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID para eliminar no es válido.");
        }
        if (!metodoPagoRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede eliminar, el método de pago con ID " + id + " no existe.");
        }
        metodoPagoRepository.deleteById(id);
    }
}