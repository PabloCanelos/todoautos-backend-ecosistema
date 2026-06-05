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

import com.todoautos.usuarios.entity.Rol;
import com.todoautos.usuarios.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    //creacion de rol
    @PostMapping
    public Rol crearRol(@RequestBody Rol rol){
        return rolService.crearRol(rol);

    }

    //listar roles
    @GetMapping("/listar")
    public List<Rol>listarRoles(){
        return rolService.listarRoles();
    }

    //buscar rol por su id
    @GetMapping("/{id}")
    public Rol buscarPorId(@PathVariable Integer id){
        return rolService.buscarPorId(id);

    }
    //eliminarun rol
    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Integer id){
        rolService.eliminarRol(id);

    }
    @PutMapping("/actualizar")
    public Rol actualizar(@RequestBody Rol rol) {
        return rolService.actualizarRol(rol);
    }


}
