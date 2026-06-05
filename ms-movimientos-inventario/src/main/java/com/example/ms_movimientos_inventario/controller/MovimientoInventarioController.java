package com.example.ms_movimientos_inventario.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_movimientos_inventario.model.MovimientoInventario;
import com.example.ms_movimientos_inventario.service.MovimientoInventarioService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoInventarioController {

    @Autowired
    private MovimientoInventarioService movimientoInventarioService;

    @PostMapping("/guardar")
    public MovimientoInventario guardar(@RequestBody MovimientoInventario movimiento){
        return movimientoInventarioService.guardarMovimiento(movimiento);
    }

    @GetMapping("/listar")
    public List<MovimientoInventario> listar(){
        return movimientoInventarioService.listarTodo();
    }

    @GetMapping("/buscar/{id}")
    public MovimientoInventario buscar(@PathVariable Integer id){
        return movimientoInventarioService.buscarPorId(id);
    }

}
