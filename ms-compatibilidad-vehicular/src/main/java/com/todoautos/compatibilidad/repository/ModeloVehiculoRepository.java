package com.todoautos.compatibilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.compatibilidad.entity.ModeloVehiculo;
@Repository
public interface ModeloVehiculoRepository extends JpaRepository<ModeloVehiculo, Integer>{

}
