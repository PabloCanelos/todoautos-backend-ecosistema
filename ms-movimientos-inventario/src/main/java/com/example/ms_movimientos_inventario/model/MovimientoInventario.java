package com.example.ms_movimientos_inventario.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimientoInventario;
    private LocalDate fechaMovimientoInventario;
    private int cantidadMovimientoInventario;


    public MovimientoInventario() {
        this.fechaMovimientoInventario = LocalDate.now();
        this.cantidadMovimientoInventario = 0;
    }


    public Integer getIdMovimientoInventario() {
        return idMovimientoInventario;
    }


    public void setIdMovimientoInventario(Integer idMovimientoInventario) {
        this.idMovimientoInventario = idMovimientoInventario;
    }


    public LocalDate getFechaMovimientoInventario() {
        return fechaMovimientoInventario;
    }


    public void setFechaMovimientoInventario(LocalDate fechaMovimientoInventario) {
        this.fechaMovimientoInventario = fechaMovimientoInventario;
    }


    public int getCantidadMovimientoInventario() {
        return cantidadMovimientoInventario;
    }


    public void setCantidadMovimientoInventario(int cantidadMovimientoInventario) {
        this.cantidadMovimientoInventario = cantidadMovimientoInventario;
    }



}
