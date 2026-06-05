package com.todoautos.usuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.usuarios.entity.Permiso;
import com.todoautos.usuarios.repository.PermisoRepository;
import com.todoautos.usuarios.util.utilValidaciones.DataValidator;

@Service
public class PermisoService  {
    @Autowired
    public PermisoRepository permisoRepository;

    //importacion de la clase validator
    @Autowired
    private DataValidator validator;


    //permiso se reutilizara como metodo para crear
    public Permiso crearPermiso(Permiso permiso) {
    if (permiso == null) {
        throw new RuntimeException("El objeto no existe, o es nulo");
    }

    // 1. Limpieza inicial de espacios fantasmas
    if (permiso.getNombrePermiso() != null) permiso.setNombrePermiso(permiso.getNombrePermiso().trim());
    if (permiso.getDescripcionPermiso() != null) permiso.setDescripcionPermiso(permiso.getDescripcionPermiso().trim());

    // 2. Delegamos las validaciones pesadas a la herramienta genérica
        validator.validateFormatName(permiso.getNombrePermiso(), "Nombre del Permiso");
        validator.validateDescription(permiso.getDescripcionPermiso(), 10, 255);

    // 3. Validación de duplicidad en base de datos
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
