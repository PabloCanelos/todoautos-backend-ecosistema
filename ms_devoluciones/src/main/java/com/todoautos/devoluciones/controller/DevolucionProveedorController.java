package com.todoautos.devoluciones.controller;

import com.todoautos.devoluciones.entity.DevolucionProveedor;
import com.todoautos.devoluciones.service.DevolucionProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devoluciones-proveedor")
public class DevolucionProveedorController {

    @Autowired
    private DevolucionProveedorService devolucionProveedorService;

    @GetMapping("/listar")
    public List<DevolucionProveedor> listarDevolucionesProveedor(){
        return devolucionProveedorService.obtenerDevolucionesProveedor();
    }

    @PostMapping
    public DevolucionProveedor crearDevolucionProveedor(@RequestBody DevolucionProveedor devolucionProveedor){
        return devolucionProveedorService.guardarDevolucionProveedor(devolucionProveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminarDevolucionProveedor(@PathVariable Integer id) {
        devolucionProveedorService.eliminarDevolucionProveedor(id);
    }
    // Buscar por ID
    @GetMapping("/{id}")
    public DevolucionProveedor buscarPorId(@PathVariable Integer id) {

        return devolucionProveedorService.buscarPorId(id);
    }
}