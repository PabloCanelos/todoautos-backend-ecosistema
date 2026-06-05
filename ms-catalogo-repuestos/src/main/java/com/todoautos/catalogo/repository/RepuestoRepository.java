package com.todoautos.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.catalogo.entity.Repuesto;
@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer>{

}
