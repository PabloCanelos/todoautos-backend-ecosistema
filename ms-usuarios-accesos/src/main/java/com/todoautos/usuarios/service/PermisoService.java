package com.todoautos.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Permiso;
import com.todoautos.usuarios.repository.PermisoRepository;

@Service
public class PermisoService  {
    @Autowired
    public PermisoRepository permisoRepository;


    //permiso se reutilizara como metodo para crear
    public Permiso crearPermiso(Permiso permiso) {
        if(permiso == null ){
            throw new RuntimeException("El objeto no existe, o es nulo");
        }
        if(permiso.getNombrePermiso() == null || permiso.getNombrePermiso().trim().length()<2){
            throw new IllegalArgumentException("El nombre del permiso es obligatorio y debe tener al menos 2 caracteres");
        }
        if (!permiso.getNombrePermiso().trim().matches("^[A-Z_]+$")) {
        throw new IllegalArgumentException("El formato del permiso es inválido. Debe usar solo letras mayúsculas y guiones bajos (Ej: CREAR_ORDEN).");
        }
        // 3. VALIDACIÓN DE DUPLICIDAD
        // Buscamos en la base de datos si el nombre ya está tomado
        Optional<Permiso> permisoExistente = permisoRepository.findByNombrePermiso(permiso.getNombrePermiso());

        if (permisoExistente.isPresent()) {
            throw new RuntimeException("Error: El permiso '" + permiso.getNombrePermiso() + "' ya existe.");
        }
        
        return permisoRepository.save(permiso);
    }




    // Listar todos los permisos disponibles para que Sergio y Marcelo los vean en el front
    public List<Permiso> listarPermisos() {
        return permisoRepository.findAll();
    }

    // Buscar un permiso por su ID para validaciones
    public Permiso buscarPorId(Integer id) {
        if(id == null){
            throw new RuntimeException("Error: El id ingresado no existe");
        }
        return permisoRepository.findById(id).orElse(null);
    }

    // Eliminar un permiso si ya no es necesario en el microservicio
    public void eliminarPermiso(Integer id) {
        if(id== null){
            throw new RuntimeException("Error: ID no encontrado");
        }
        permisoRepository.deleteById(id);
    }
    // Método para actualizar permiso (se usa el ID que viene en el objeto)
    public Permiso actualizarPermiso(Permiso permiso) {
        if(permiso == null){
            throw new RuntimeException("NO hay nada para actualizar , base de datos esta vacia");
        }
        return permisoRepository.save(permiso);
    }

}
