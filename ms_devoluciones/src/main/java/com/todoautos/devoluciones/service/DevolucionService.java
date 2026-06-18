package com.todoautos.devoluciones.service;

import com.todoautos.devoluciones.devolucionesDTO.VentasDTO;
import com.todoautos.devoluciones.devolucionesDTO.RepuestoDTO;
import com.todoautos.devoluciones.entity.Devolucion;
import com.todoautos.devoluciones.repository.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Devolucion procesarDevolucion(Devolucion devolucion) {
        // 1. Validar existencia de Venta
        String urlVenta = "http://MS-VENTAS-TRANSACCIONES/api/ventas/" + devolucion.getIdVenta();
        VentasDTO venta = restTemplate.getForObject(urlVenta, VentasDTO.class);

        if (venta == null) {
            throw new RuntimeException("Error: La venta con ID " + devolucion.getIdVenta() + " no existe.");
        }

        // 2. Obtener el repuesto
        String urlRepuesto = "http://MS-CATALOGO-REPUESTOS/api/repuestos/" + venta.getIdRepuesto();
        RepuestoDTO repuestoDTO = restTemplate.getForObject(urlRepuesto, RepuestoDTO.class);

        if (repuestoDTO == null) {
            throw new RuntimeException("Error: El repuesto asociado a la venta no existe.");
        }

        // 3. Incremento Robusto usando tu DTO actual (getStock / setStock)
        // Esto evita el NullPointerException si el stock llega como null
        Integer stockActual = repuestoDTO.getStock();
        int nuevoStock = (stockActual != null) ? stockActual + 1 : 1;

        repuestoDTO.setStock(nuevoStock);

        // 4. Actualizar repuesto mediante PUT
        try {
            String urlActualizar = "http://MS-CATALOGO-REPUESTOS/api/repuestos/actualizar";
            restTemplate.put(urlActualizar, repuestoDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con el servicio de catálogo: " + e.getMessage());
        }

        // 5. Guardar la devolución
        return devolucionRepository.save(devolucion);
    }
    public List<Devolucion> listarTodasLasDevoluciones() {
        return devolucionRepository.findAll();
    }

    public Devolucion guardarDevolucion(Devolucion devolucion) {
        if (devolucion == null) {
            throw new RuntimeException("Error: El objeto de devolución no puede ser nulo.");
        }
        return devolucionRepository.save(devolucion);
    }

    public void eliminarDevolucion(Integer id) {
        if (id == null || !devolucionRepository.existsById(id)) {
            throw new RuntimeException("Error: El ID " + id + " no está registrado.");
        }
        devolucionRepository.deleteById(id);
    }

    public void actualizarDevolucion(Devolucion dev) {
        if (dev == null || dev.getIdDevolucion() == null) {
            throw new RuntimeException("ERROR: El objeto de devolución es inválido.");
        }
        devolucionRepository.save(dev);
    }

    public Devolucion buscarDevolucionPorId(Integer id) {
        return devolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: El ID " + id + " no existe en la base de datos."));
    }
}