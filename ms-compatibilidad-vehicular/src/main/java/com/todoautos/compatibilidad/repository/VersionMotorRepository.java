package com.todoautos.compatibilidad.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoautos.compatibilidad.entity.VersionMotor;
@Repository
public interface VersionMotorRepository extends JpaRepository<VersionMotor, Integer>{

}
