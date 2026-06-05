package com.todoautos.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Rol;
import com.todoautos.usuarios.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    //creacion de rol
    public Rol crearRol(Rol rol){
        if(rol == null){
            throw new RuntimeException("Error: Objeto no encontrado");
        }
        return rolRepository.save(rol);

    }

    //listar roles
    public List<Rol>listarRoles(){
        return rolRepository.findAll();
    }

    //buscar rol por su id
    public Rol buscarPorId(Integer id){
        if(id == null){
            throw new RuntimeException("Error: Id buscado no esta registrado en la base de datos");
        }
        return rolRepository.findById(id).orElse(null);

    }
    //eliminarun rol
    public void eliminarRol(Integer id){
        if(id== null){
            throw new RuntimeException("ERROR:EL id que desea eliminar no ha sido encontrado");
        }
        rolRepository.deleteById(id);

    }
    // Método para actualizar un rol
    public Rol actualizarRol(Rol rol) {
        if(rol == null){
            throw new RuntimeException("Error: NO existe el objeto en la base de datos");
        }
        return rolRepository.save(rol);
    }




}
