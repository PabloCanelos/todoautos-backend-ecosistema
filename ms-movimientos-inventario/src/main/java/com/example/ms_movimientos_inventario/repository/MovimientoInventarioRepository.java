package com.example.ms_movimientos_inventario.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ms_movimientos_inventario.model.MovimientoInventario;

public interface MovimientoInventarioRepository extends JpaRepository <MovimientoInventario, Integer> {


}
