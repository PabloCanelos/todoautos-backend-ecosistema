package com.todoautos.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoautos.catalogo.entity.Repuesto;
import com.todoautos.catalogo.repository.RepuestoRepository;

@Service
public class RepuestoService {
    @Autowired
    private RepuestoRepository repuestoRepository;

    // Crear un nuevo repuesto en el catálogo
    // public Repuesto crearRepuesto(Repuesto repuesto) {
    //     if(repuesto == null){
    //         throw new RuntimeException("Error: El objeto repuestto no puede quedar vacio");
    //     }
    //     if(repuesto.getNombreRepuesto() == null || repuesto.getNombreRepuesto().trim().isEmpty()){
    //         throw new RuntimeException("El nombre del repuesto es obligatorio y no puede estar vacio");
    //     }
    //     if(repuesto.getPrecioVentaRepuesto()== null || repuesto.getPrecioVentaRepuesto()<0){
    //         throw new RuntimeException("El precio de venta no es valido. NO puede ser menor a 0");
    //     }
    //     if(repuesto.getCategoria()==null || repuesto.getCategoria().getIdCategoria()== null){
    //         throw new RuntimeException("Error: Debe asignar una categoria Valida para registrar el repuesto");

    //     }
    //     return repuestoRepository.save(repuesto);
    // }


    // 2.Buscar un repuesto por su ID (para ver detalles o stock)
    public Repuesto buscarPorId(Integer id) {
        if(id== null || id<=0){
            throw new RuntimeException("Error: El ID proporcionado" + id + "no es valido");
        }
        return repuestoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("El repuesto con ID " + id+ " no existe en el sistema"));
    }

    // Listar todos los repuestos
    public List<Repuesto> listarRepuestos() {
        List<Repuesto> lista= repuestoRepository.findAll();
        if(lista.isEmpty()){
            throw new RuntimeException("No se encontraron repuestos registrados en el sistema");
        }
        return lista;

    }


    //ACTUALIZAR DATOS

    // public Repuesto actualizarRepuesto(Repuesto repuesto){
    //     // 1. ESCUDO: Validación de existencia e ID
    //     if(repuesto.getIdRepuesto()== null || repuesto.getIdRepuesto() <=0){
    //         throw new RuntimeException("Error: se requiere un id valido para actulizar. Este no puede ser menor a 1");
    //     }

    //     // 2. ESCUDO: Re-validar lógica de negocio (Precio y Stock)
    //     if(repuesto.getPrecioVentaRepuesto()!= null && repuesto.getPrecioVentaRepuesto()<0){
    //         throw new RuntimeException("El precio no puedeser negativo");
    //     }
    //     //ESCUDO: No ingresar valores negativos
    //     if(repuesto.getCantidadRepuesto()  != null && repuesto.getCantidadRepuesto()<0){
    //         throw new RuntimeException("El stock no puede ser negativo");
    //     }
    //     // 3. ESCUDO: Integridad de la categoría si se está modificando
    //     if(repuesto.getCategoria()!= null && repuesto.getCategoria().getIdCategoria()!= null){
    //         throw new RuntimeException("La nueva categoria asignada no existe");
    //     }
    //     return repuestoRepository.save(repuesto);
    // }
    // Eliminar un repuesto del sistema
    public void eliminarRepuesto(Integer id) {
        // 1. ESCUDO: Validación de ID
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID " + id + " no es válido para eliminar.");
        }

        // 2. ESCUDO: Verificación de existencia antes de intentar borrar
        if (!repuestoRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede eliminar el repuesto con ID " + id + " porque no existe.");
        }

        repuestoRepository.deleteById(id);
    }





}
