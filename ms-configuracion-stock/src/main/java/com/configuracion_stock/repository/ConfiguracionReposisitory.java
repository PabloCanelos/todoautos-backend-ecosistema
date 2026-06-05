package com.configuracion_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configuracion_stock.entity.ConfiguracionStockEntity;
@Repository
public interface ConfiguracionReposisitory extends JpaRepository<ConfiguracionStockEntity, Integer> {

}
