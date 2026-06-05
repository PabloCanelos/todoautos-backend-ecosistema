package com.example.ms_ventas_transacciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_ventas_transacciones.model.DetalleVenta;
import com.example.ms_ventas_transacciones.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalles-ventas")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping("/guardar")
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.guardarDetalleVenta(detalleVenta);
    }

    @GetMapping("/listar")
    public List<DetalleVenta> listar(){
        return detalleVentaService.listarDetalleVenta();
    }

    @GetMapping("/buscar")
    public DetalleVenta buscar(@PathVariable Integer id){
        return detalleVentaService.buscarPorId(id);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@PathVariable Integer id){
        detalleVentaService.eliminarDetalleVenta(id);
    }

}
