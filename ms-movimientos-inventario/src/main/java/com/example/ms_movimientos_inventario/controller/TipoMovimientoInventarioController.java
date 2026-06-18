package com.example.ms_movimientos_inventario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ms_movimientos_inventario.model.TipoMovimientoInventario;
import com.example.ms_movimientos_inventario.service.TipoMovimientoInventarioService;

@RestController
@RequestMapping("/api/tipos-movimientos")
public class TipoMovimientoInventarioController {

    @Autowired
    private TipoMovimientoInventarioService tipoService;

    @PostMapping("/guardar")
    public ResponseEntity<TipoMovimientoInventario> guardar(@RequestBody TipoMovimientoInventario tipo) {
        return ResponseEntity.ok(tipoService.guardarTipoMovimiento(tipo));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TipoMovimientoInventario>> listar() {
        return ResponseEntity.ok(tipoService.listarTodo());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoMovimientoInventario> buscarPorId(@PathVariable Integer id) {
        TipoMovimientoInventario tipo = tipoService.buscarPorId(id);
        return (tipo != null) ? ResponseEntity.ok(tipo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        tipoService.eliminarTipoMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}