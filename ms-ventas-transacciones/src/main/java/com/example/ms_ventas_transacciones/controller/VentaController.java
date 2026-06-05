package com.example.ms_ventas_transacciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_ventas_transacciones.model.Venta;
import com.example.ms_ventas_transacciones.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/guardar")
    public Venta guardar(@RequestBody Venta venta){
        return ventaService.guardarVenta(venta);
    }

    @GetMapping("/listar")
    public List<Venta> listar(){
        return ventaService.listarVenta();
    }

    @GetMapping("/buscar")
    public Venta buscar(@PathVariable Integer id){
        return ventaService.buscarPorId(id);
    }

}
