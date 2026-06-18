package com.example.ms_ventas_transacciones.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hace que el ID sea autoincremental
    private Integer idVenta;

    private LocalDate fechaVenta;
    private String rutCliente;

    // --- NUEVO CAMPO: FK hacia el catálogo ---
    private Integer idRepuesto;

    public Venta() {
        this.fechaVenta = LocalDate.now();
    }

    // --- GETTERS Y SETTERS ---

    public Integer getIdVenta() { return idVenta; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }

    public LocalDate getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDate fechaVenta) { this.fechaVenta = fechaVenta; }

    public String getRutCliente() { return rutCliente; }
    public void setRutCliente(String rutCliente) { this.rutCliente = rutCliente; }

    public Integer getIdRepuesto() { return idRepuesto; }
    public void setIdRepuesto(Integer idRepuesto) { this.idRepuesto = idRepuesto; }
}