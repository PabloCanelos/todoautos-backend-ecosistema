package com.todoautos.devoluciones.service;

import com.todoautos.devoluciones.entity.DevolucionProveedor;
import com.todoautos.devoluciones.repository.DevolucionProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionProveedorService {

    @Autowired
    private DevolucionProveedorRepository devolucionProveedorRepository;

    // Listar todos
    public List<DevolucionProveedor> obtenerDevolucionesProveedor() {
        return devolucionProveedorRepository.findAll();
    }

    // Crear nuevo
    public DevolucionProveedor guardarDevolucionProveedor(DevolucionProveedor devolucionProveedor) {
        if (devolucionProveedor == null) {
            throw new RuntimeException("Error: El objeto de devolución no puede ser nulo.");
        }
        return devolucionProveedorRepository.save(devolucionProveedor);
    }

    // Buscar por ID
    public DevolucionProveedor buscarPorId(Integer id) {
        if(id== null){
            throw new RuntimeException("Error: El id no ha sido encontrado enla base de datos");
        }
        return devolucionProveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: El id " + id + " no existe en la base de datos."));
    }



    // Eliminar
    public void eliminarDevolucionProveedor(Integer id) {
        if(id== null){
            throw new RuntimeException("ERROR: El id a eliminar no existe no existe enla base de datos");
        }else{
            devolucionProveedorRepository.deleteById(id);
        }

    }}