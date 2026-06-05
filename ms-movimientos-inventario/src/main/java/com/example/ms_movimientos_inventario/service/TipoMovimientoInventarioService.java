package com.example.ms_movimientos_inventario.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_movimientos_inventario.model.TipoMovimientoInventario;
import com.example.ms_movimientos_inventario.repository.TipoMovimientoInventarioRepository;

@Service
public class TipoMovimientoInventarioService {
    @Autowired
    private TipoMovimientoInventarioRepository tipoMovimientoInventarioRepository;

    public TipoMovimientoInventario guardarTipoMovimiento(TipoMovimientoInventario tipoMovimientoInventario){
        return tipoMovimientoInventarioRepository.save(tipoMovimientoInventario);
    }

    public List<TipoMovimientoInventario> listarTodo(){
        return tipoMovimientoInventarioRepository.findAll();
    }

    public TipoMovimientoInventario buscarPorId(Integer id){
        return tipoMovimientoInventarioRepository.findById(id).orElse(null);
    }

    public void eliminarTipoMovimiento(Integer id){
        tipoMovimientoInventarioRepository.deleteById(id);
    }

}
