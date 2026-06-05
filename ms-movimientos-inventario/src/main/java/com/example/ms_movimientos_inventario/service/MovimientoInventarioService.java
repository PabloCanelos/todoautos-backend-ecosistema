package com.example.ms_movimientos_inventario.service;
import com.example.ms_movimientos_inventario.repository.MovimientoInventarioRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.example.ms_movimientos_inventario.model.MovimientoInventario;

@Service
public class MovimientoInventarioService {
    
    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;

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
