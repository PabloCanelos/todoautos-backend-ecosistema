package com.example.ms_bodega_ubicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ms_bodega_ubicacion.model.BodegaUbicacion;

@Repository
public interface BodegaUbicacionRepository extends JpaRepository<BodegaUbicacion, Integer>{

}


