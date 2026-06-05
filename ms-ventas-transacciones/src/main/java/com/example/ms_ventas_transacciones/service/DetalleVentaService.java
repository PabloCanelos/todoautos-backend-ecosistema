package com.example.ms_ventas_transacciones.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ms_ventas_transacciones.model.DetalleVenta;
import com.example.ms_ventas_transacciones.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta){
        return detalleVentaRepository.save(detalleVenta);
    }

    public List<DetalleVenta> listarDetalleVenta(){
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta buscarPorId(Integer id){
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public void eliminarDetalleVenta(Integer id){
        detalleVentaRepository.deleteById(id);
    }

}
