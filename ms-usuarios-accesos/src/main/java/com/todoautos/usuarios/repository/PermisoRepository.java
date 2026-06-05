package com.todoautos.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.usuarios.entity.Permiso;
@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    //metodo para verificar la existencia de un oermiso que sera vaidado en service
    Optional<Permiso> findByNombrePermiso(String nombrePermiso);
}
