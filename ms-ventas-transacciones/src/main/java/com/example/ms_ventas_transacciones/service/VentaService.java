package com.example.ms_ventas_transacciones.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ms_ventas_transacciones.model.Venta;
import com.example.ms_ventas_transacciones.repository.VentaRepository;
import com.example.ms_ventas_transacciones.ventasDTO.ClienteDTO;
import com.example.ms_ventas_transacciones.ventasDTO.RepuestoDTO;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Venta guardarVenta(Venta venta) {
        // 1. Validar Cliente (Usando el método auxiliar)
        if (!validarClienteExistente(venta.getRutCliente())) {
            throw new RuntimeException("Error: El cliente con RUT " + venta.getRutCliente() + " no existe.");
        }

        // 2. Obtener y Validar Repuesto (Para poder descontar stock)
        String urlRepuesto = "http://ms-catalogo-repuestos/api/repuestos/" + venta.getIdRepuesto();
        RepuestoDTO repuesto = restTemplate.getForObject(urlRepuesto, RepuestoDTO.class);

        if (repuesto == null) {
            throw new RuntimeException("Error: El repuesto solicitado no existe.");
        }

        // Validación de stock disponible
        if (repuesto.getStock() < 1) {
            throw new RuntimeException("Error: El repuesto seleccionado no tiene stock disponible.");
        }

        // 3. Descontar Stock en el catálogo (Flujo profesional)
        repuesto.setStock(repuesto.getStock() - 1);
        String urlActualizar = "http://ms-catalogo-repuestos/api/repuestos/actualizar";
        restTemplate.put(urlActualizar, repuesto);

        // 4. Guardar la venta
        venta.setFechaVenta(LocalDate.now());
        return ventaRepository.save(venta);
    }

    public boolean validarClienteExistente(String rutCliente) {
        String url = "http://ms-gestion-clientes/api/clientes/" + rutCliente;
        try {
            ClienteDTO cliente = restTemplate.getForObject(url, ClienteDTO.class);
            return cliente != null;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Venta> listarVenta() {
        return ventaRepository.findAll();
    }

    public Venta buscarPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }
}