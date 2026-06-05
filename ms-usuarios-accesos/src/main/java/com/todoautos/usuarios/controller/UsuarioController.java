package com.todoautos.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoautos.usuarios.entity.Usuario;
import com.todoautos.usuarios.service.UsuarioService;
@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //metodo para la creacion de un usuario
    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario user){
        return usuarioService.agregarUsuario(user);

    }

    //metodo para mostrar los usuairos creados
    @GetMapping("/listar")
    public List<Usuario>listarUsuarios(){
        return usuarioService.listarUsuario();
    }
    //BUSCAR POR ID
    @GetMapping("/{id}")
        public Usuario buscarPorId(@PathVariable Integer id){
            return usuarioService.buscarPorId(id);

        }
    @PutMapping
    public Usuario actualizarUsuario(@RequestBody Usuario user){
        return usuarioService.actualizarUsuario(user);
    }

    //METODO PARA ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);;

    }

}
