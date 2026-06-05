package com.todoautos.compatibilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.compatibilidad.entity.Compatibilidad;

@Repository
public interface CompatibilidadRepository extends JpaRepository<Compatibilidad, Integer>{

}
