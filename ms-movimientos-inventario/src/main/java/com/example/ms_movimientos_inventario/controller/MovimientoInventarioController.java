package com.example.ms_movimientos_inventario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ms_movimientos_inventario.inventarioDTO.MovimientoInventarioDTO;
import com.example.ms_movimientos_inventario.model.MovimientoInventario;
import com.example.ms_movimientos_inventario.service.MovimientoInventarioService;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoInventarioController {

    @Autowired
    private MovimientoInventarioService movimientoService;

    @PostMapping("/guardar")
    public ResponseEntity<MovimientoInventario> guardar(@RequestBody MovimientoInventarioDTO dto) {
        MovimientoInventario nuevoMovimiento = movimientoService.registrarMovimiento(dto);
        return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovimientoInventario>> listar() {
        return ResponseEntity.ok(movimientoService.listarTodo());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MovimientoInventario> buscarPorId(@PathVariable Integer id) {
        MovimientoInventario movimiento = movimientoService.buscarPorId(id);
        return (movimiento != null) ? ResponseEntity.ok(movimiento) : ResponseEntity.notFound().build();
    }
}