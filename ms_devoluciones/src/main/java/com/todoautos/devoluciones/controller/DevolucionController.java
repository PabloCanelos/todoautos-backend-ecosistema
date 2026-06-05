package com.todoautos.devoluciones.controller;

import com.todoautos.devoluciones.entity.Devolucion;
import com.todoautos.devoluciones.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping("/listar")
    public List<Devolucion> listarDevoluciones(){
        return devolucionService.obtenerDevoluciones();
    }

    @PostMapping("/crear_devolucion")
    public Devolucion crearDevolucion(@RequestBody Devolucion devolucion){
        return devolucionService.guardarDevolucion(devolucion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDevolucion(@PathVariable Integer id){

            devolucionService.eliminarDevolucion(id);

    }

    @PutMapping("/actualizar")
    public void actualizarDatosDevolucion(@RequestBody Devolucion dev){
        if(dev == null){
            throw new RuntimeException("ERROR: El objeto no ha sido encontrado");
        }else{
            devolucionService.actualizarDatosDevolucion(dev);;
        }

    }
    @GetMapping("/buscar/{id}")
    public Devolucion buscarPorId(@PathVariable Integer id){
        return devolucionService.buscarPorId(id);
    }
}