package com.example.ms_ventas_transacciones.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_ventas_transacciones.model.MetodoPago;
import com.example.ms_ventas_transacciones.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodos-pagos")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    // 1. AGREGAR
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody MetodoPago metodoPago) {
        try {
            MetodoPago guardado = metodoPagoService.guardarMetodoPago(metodoPago);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 2. LISTAR TODO
    @GetMapping("/listar")
    public ResponseEntity<List<MetodoPago>> listar() {
        List<MetodoPago> lista = metodoPagoService.listarMetodoPago();
        return ResponseEntity.ok(lista);
    }

    // 3. BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            MetodoPago metodoPago = metodoPagoService.buscarPorId(id);
            if (metodoPago == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Error: El método de pago con ID " + id + " no fue encontrado.");
            }
            return ResponseEntity.ok(metodoPago);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 4. ACTUALIZAR
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody MetodoPago metodoPago) {
        try {
            MetodoPago actualizado = metodoPagoService.actualizarMetodoPago(metodoPago);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            metodoPagoService.eliminarMetodoPago(id);
            return ResponseEntity.ok("Método de pago eliminado con éxito.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}