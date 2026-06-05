package com.example.ms_ventas_transacciones.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;
    private int cantidad;
    private double precioUnitarioVenta;
  //private Integer idRepuesto;

    public DetalleVenta() {
        this.cantidad = 0;
        this.precioUnitarioVenta = 0;
    }


    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }
    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }
    public void setPrecioUnitarioVenta(double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }


}
