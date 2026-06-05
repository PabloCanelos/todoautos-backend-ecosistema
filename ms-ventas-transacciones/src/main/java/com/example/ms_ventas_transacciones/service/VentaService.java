package com.example.ms_ventas_transacciones.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ms_ventas_transacciones.model.Venta;
import com.example.ms_ventas_transacciones.repository.VentaRepository;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;


    public Venta guardarVenta(Venta venta){
        venta.setFechaVenta(LocalDate.now());
        return ventaRepository.save(venta);
    }

    public List<Venta> listarVenta(){
        return ventaRepository.findAll();
    }

    public Venta buscarPorId(Integer id){
        return ventaRepository.findById(id).orElse(null);
    }

}
