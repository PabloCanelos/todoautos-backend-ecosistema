package com.todoautos.devoluciones.repository;

import com.todoautos.devoluciones.entity.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
}