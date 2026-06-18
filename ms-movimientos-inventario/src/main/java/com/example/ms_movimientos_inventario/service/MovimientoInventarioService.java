package com.example.ms_movimientos_inventario.service;
import com.example.ms_movimientos_inventario.repository.MovimientoInventarioRepository;
import com.example.ms_movimientos_inventario.repository.TipoMovimientoInventarioRepository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_movimientos_inventario.inventarioDTO.MovimientoInventarioDTO;
import com.example.ms_movimientos_inventario.model.MovimientoInventario;
import com.example.ms_movimientos_inventario.model.TipoMovimientoInventario;

@Service
public class MovimientoInventarioService {

    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;
    @Autowired
    private TipoMovimientoInventarioRepository tipoMovimientoInventarioRepository;

    public MovimientoInventario registrarMovimiento(MovimientoInventarioDTO dto) {
        // 1. Buscar el tipo de movimiento usando el nombre correcto de la variable inyectada
        TipoMovimientoInventario tipo = tipoMovimientoInventarioRepository.findById(dto.getIdTipoMovimiento())
            .orElseThrow(() -> new RuntimeException("Tipo de movimiento no encontrado"));

        // 2. Crear la entidad y asignar datos
        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setIdRepuesto(dto.getIdRepuesto());
        movimiento.setCantidadMovimientoInventario(dto.getCantidadMovimientoInventario());
        movimiento.setTipoMovimiento(tipo);

        // 3. Guardar usando la variable correcta
        return movimientoInventarioRepository.save(movimiento);
    }

    public MovimientoInventario guardarMovimiento(MovimientoInventario movimiento){
        movimiento.setFechaMovimientoInventario(LocalDate.now());
        return movimientoInventarioRepository.save(movimiento);
    }

    public List<MovimientoInventario> listarTodo(){
        return movimientoInventarioRepository.findAll();
    }

    public MovimientoInventario buscarPorId(Integer id){
        return movimientoInventarioRepository.findById(id).orElse(null);
    }

}
