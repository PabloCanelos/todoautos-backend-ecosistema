package com.todoautos.compatibilidad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoautos.compatibilidad.entity.MarcaVehiculo;
import com.todoautos.compatibilidad.service.MarcaVehiculoService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaVehiculoController {

    @Autowired
    private MarcaVehiculoService marcaService;

    // 1. LISTAR MARCAS
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        try {
            List<MarcaVehiculo> lista = marcaService.listarTodo();
            return ResponseEntity.ok(lista);
        } catch (RuntimeException e) {
            // Si la lista está vacía, devolvemos un mensaje claro
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    // 2. BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        try {
            MarcaVehiculo encontrada = marcaService.buscarPorId(id);
            return ResponseEntity.ok(encontrada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 3. AGREGAR MARCA (Aquí validará si el nombre ya existe)
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody MarcaVehiculo marca) {
        try {
            MarcaVehiculo guardada = marcaService.guardarMarca(marca);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
        } catch (RuntimeException e) {
            // Si el nombre está repetido o es nulo, enviamos un 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 4. ACTUALIZAR MARCA
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody MarcaVehiculo marca) {
        try {
            MarcaVehiculo actualizada = marcaService.actualizarMarca(marca);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 5. ELIMINAR MARCA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            marcaService.eliminarMarca(id);
            return ResponseEntity.ok("Marca eliminada exitosamente.");
        } catch (RuntimeException e) {
            // Captura si el ID no existe o si tiene modelos vinculados
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}