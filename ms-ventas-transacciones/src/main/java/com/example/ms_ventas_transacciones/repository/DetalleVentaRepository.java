package com.example.ms_ventas_transacciones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms_ventas_transacciones.model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository <DetalleVenta, Integer> {

}
