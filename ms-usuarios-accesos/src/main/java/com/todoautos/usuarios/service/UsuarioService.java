package com.todoautos.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Usuario;
import com.todoautos.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //creacion nuevo usuario
    public Usuario agregarUsuario(Usuario user){
        if(user == null){
            throw new RuntimeException("Error al registrar usuario");
        }
        return usuarioRepository.save(user);

    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    //metodo para buscar por id

    public Usuario buscarPorId(Integer id){
        if(id== null){
            throw new RuntimeException("Error: Id buscado no existe");
        }
        return usuarioRepository.findById(id).orElse(null);

    }

    //ACTUALIZAR
    public Usuario actualizarUsuario(Usuario user){
        if(user == null){
            throw new RuntimeException("El usuario que quiere actualizar no existe");
        }
        return usuarioRepository.save(user);
    }

    //METODO PARA ELIMINAR
    public void eliminarUsuario(Integer id){
        if(id == null){
            throw new RuntimeException("Error: El Id que busca para eliminar no esta registrado en la base de datos");
        }
        usuarioRepository.deleteById(id);

    }
}
