package com.todoautos.catalogo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.catalogo.entity.CategoriaRepuesto;
@Repository
public interface CategoriaRepuestoRepository extends JpaRepository<CategoriaRepuesto, Integer> {

}
