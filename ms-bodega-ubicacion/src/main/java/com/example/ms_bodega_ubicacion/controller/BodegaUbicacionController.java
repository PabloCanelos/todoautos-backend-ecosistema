package com.example.ms_bodega_ubicacion.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_bodega_ubicacion.model.BodegaUbicacion;
import com.example.ms_bodega_ubicacion.service.BodegaUbicacionService;

@RestController
@RequestMapping("api/ubicaciones")
public class BodegaUbicacionController {
    @Autowired
    private BodegaUbicacionService bodegaUbicacionService;

    @PostMapping
    public BodegaUbicacion guardar(@RequestBody BodegaUbicacion ubicacion){
        return bodegaUbicacionService.guardarUbicacion(ubicacion);
    }

    @GetMapping("/listar")
    public List<BodegaUbicacion> listar(){
        return bodegaUbicacionService.listarTodo();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<BodegaUbicacion> buscar(@PathVariable Integer id){
        BodegaUbicacion ubicacion = bodegaUbicacionService.buscarPorId(id);
        if (ubicacion != null) {
            return new ResponseEntity<>(ubicacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/eliminar")
    public void eliminar(@PathVariable Integer id){
        bodegaUbicacionService.eliminarUbicacion(id);
    }

}
