package com.todoautos.compatibilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.compatibilidad.entity.MarcaVehiculo;
@Repository
public interface MarcaVehiculoRepository extends JpaRepository<MarcaVehiculo, Integer> {
    // Este método permite que Spring Boot genere el SQL:
    // SELECT COUNT(*) FROM marca_vehiculo WHERE nombre_marca_vehiculo = ?
    boolean existsByNombreMarcaVehiculo(String nombreMarcaVehiculo);

}
