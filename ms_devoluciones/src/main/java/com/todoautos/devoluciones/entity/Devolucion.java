package com.todoautos.devoluciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDevolucion;

    private LocalDate fechaDevolucion;

    // @ManyToOne
    // @JoinColumn(name = "idDevolucionProveedor")
    // private DevolucionProveedor devProveedor;

    public Devolucion() {}

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // public DevolucionProveedor getDevProveedor() {
    //     return devProveedor;
    // }

    // public void setDevProveedor(DevolucionProveedor devProveedor) {
    //     this.devProveedor = devProveedor;
    // }
}
