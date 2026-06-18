package com.todoautos.clientes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoautos.clientes.entity.Cliente;
import com.todoautos.clientes.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // 1. CREAR
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente guardado = clienteService.guardarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 2. LISTAR TODO
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> lista = clienteService.listarClientes();
        return ResponseEntity.ok(lista);
    }

    // 3. BUSCAR POR ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            Cliente cliente = clienteService.buscarPorId(id);
            if (cliente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Error: El cliente con el ID " + id + " no fue encontrado.");
            }
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 4. ACTUALIZAR
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente actualizado = clienteService.actualizarCliente(cliente);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 5. ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.ok("Cliente eliminado con éxito.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //========================================================
    /*
    cOMUNICACION CON MS EXTERNO, este es euqe envia informacion al receptor ms-venta-transacciones
*/
    @GetMapping("/{rut}")
    public ResponseEntity<?> obtenerPorRut(@PathVariable String rut) {
        System.out.println("Buscando RUT: " + rut); // <-- MIRA LA CONSOLA
        Cliente cliente = clienteService.buscarPorRut(rut);

        if (cliente == null) {
            System.out.println("El cliente NO fue encontrado en la BD");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el cliente");
        }

        System.out.println("Cliente encontrado: " + cliente.getPrimerNombreCliente()); // <-- MIRA LA CONSOLA
        return ResponseEntity.ok(cliente);
    }
}