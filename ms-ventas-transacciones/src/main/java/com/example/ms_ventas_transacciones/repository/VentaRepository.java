package com.example.ms_ventas_transacciones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms_ventas_transacciones.model.Venta;

public interface VentaRepository extends JpaRepository <Venta, Integer>{

}
