package com.example.ms_ventas_transacciones.model;

import java.time.LocalDate;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;

@Entity
public class Venta {

    @Id
    private Integer idVenta;
    private LocalDate fechaVenta;

    // @OneToOne
    // @JoinColumn(name="idVenta")
    // @JsonBackReference
    // private DetalleVenta detalleVenta;

    public Venta() {

        this.fechaVenta = LocalDate.now() ;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


}
