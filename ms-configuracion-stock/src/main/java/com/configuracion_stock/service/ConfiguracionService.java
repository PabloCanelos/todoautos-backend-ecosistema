package com.configuracion_stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuracion_stock.entity.ConfiguracionStockEntity;
import com.configuracion_stock.repository.ConfiguracionReposisitory;

@Service
public class ConfiguracionService {
    @Autowired
    private ConfiguracionReposisitory configuracionRepository;

    //***************LLAMAMOS AL REST TEMPLATE Y CREAMOS UN METODO****************************

    // Listar todas las configuraciones para que el Encargado de Bodega las supervise
    public List<ConfiguracionStockEntity> listarConfiguraciones() {
        List<ConfiguracionStockEntity> lista = configuracionRepository.findAll();

        // Validación profesional: Si no hay datos, lanzamos un error controlado
        if (lista.isEmpty()) {
            throw new RuntimeException("No hay configuraciones de stock registradas.");
        }

            return lista;
        }

    public ConfiguracionStockEntity buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID solicitado no es válido.");
        }
        return configuracionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("La configuración de stock con el ID " + id + " no existe en el sistema."));
    }


    public void eliminarConfiguracion(Integer id) {
        // 1. Validación de nulos básica
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID del objeto no puede ser nulo o inválido.");
        }

        // 2. Validación de existencia real en la Base de Datos
        if (!configuracionRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: La configuración de stock con el ID " + id + " no existe.");
        }

        // 3. Si pasó la validación, se elimina con seguridad
        configuracionRepository.deleteById(id);
    }

    // Método exclusivo para AGREGAR (Crea algo nuevo)
    public ConfiguracionStockEntity agregarStock(ConfiguracionStockEntity nuevaConfig) {
        // 1. Validar que el stock sea positivo
        if (nuevaConfig.getStockMinimo() < 0 || nuevaConfig.getStockMaximo() < 0) {
            throw new RuntimeException("Error: Los valores de stock no pueden ser negativos.");
        }

        // 2. Validar coherencia lógica
        if (nuevaConfig.getStockMaximo() <= nuevaConfig.getStockMinimo()) {
            throw new RuntimeException("Error: El stock máximo debe ser mayor al stock mínimo.");
        }

        // 3. (Opcional) Validar que el repuestoId sea válido
        if (nuevaConfig.getRepuestoId() == null || nuevaConfig.getRepuestoId() <= 0) {
            throw new RuntimeException("Error: Debe asociar un ID de repuesto válido.");
        }

        nuevaConfig.setIdConfiguracion(null);
        return configuracionRepository.save(nuevaConfig);
    }

    // Método exclusivo para ACTUALIZAR (Modifica algo existente)
    public ConfiguracionStockEntity actualizarStock(ConfiguracionStockEntity configExistente) {
        if (configExistente == null) {
            throw new RuntimeException("Error: El objeto configExistente no puede ser nulo.");
        }


        return null;
    }



}
