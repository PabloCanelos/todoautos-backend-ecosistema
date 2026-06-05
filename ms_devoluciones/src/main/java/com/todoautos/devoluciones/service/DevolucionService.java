package com.todoautos.devoluciones.service;

import com.todoautos.devoluciones.entity.Devolucion;
import com.todoautos.devoluciones.repository.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    public List<Devolucion> obtenerDevoluciones(){
        return devolucionRepository.findAll();
    }

    public Devolucion guardarDevolucion(Devolucion devolucion){
        if (devolucion == null) {
            throw new RuntimeException("Error: El objeto no puede ser nulo.");
        }
        return devolucionRepository.save(devolucion);
    }
    public void eliminarDevolucion(Integer id){
        if(id == null){
            throw new RuntimeException("Error: El id no esta registrado en la base de datos");
        }else{
            devolucionRepository.deleteById(id);
        }
    }

    public void actualizarDatosDevolucion(Devolucion dev){
        if(dev == null){
            throw new RuntimeException("ERROR: El objeto no ha sido encontrado");
        }else{
            devolucionRepository.save(dev);
        }

    }

    public Devolucion buscarPorId(Integer id){
        if(id== null){
            throw new RuntimeException("ERROR:El id buscado para eliminar no existe enla base de datos");
        }else{
            return devolucionRepository.findById(id).orElseThrow(()->new RuntimeException("Error: Elid buscado no esta registradop en la base de datos"));
        }
    }
}