package com.todoautos.devoluciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDevolucion;

    private Integer idVenta;
    private LocalDate fechaDevolucion;

    public Devolucion() {}

    public Devolucion(Integer idDevolucion, Integer idVenta, LocalDate fechaDevolucion) {
        this.idDevolucion = idDevolucion;
        this.idVenta = idVenta;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters y Setters
    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}