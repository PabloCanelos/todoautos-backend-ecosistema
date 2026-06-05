package com.example.ms_bodega_ubicacion.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_bodega_ubicacion.model.BodegaUbicacion;
import com.example.ms_bodega_ubicacion.repository.BodegaUbicacionRepository;

@Service
public class BodegaUbicacionService {
    @Autowired
    private BodegaUbicacionRepository bodegaUbicacionRepository;

    public BodegaUbicacion guardarUbicacion (BodegaUbicacion ubicacion){
        return bodegaUbicacionRepository.save(ubicacion);
    }

    public List<BodegaUbicacion> listarTodo(){
        return bodegaUbicacionRepository.findAll();
    }

    public BodegaUbicacion buscarPorId(Integer id){
        return bodegaUbicacionRepository.findById(id).orElse(null);
    }

    public void eliminarUbicacion(Integer id){
        bodegaUbicacionRepository.deleteById(id);
    }
    
    


}   
