package com.example.ms_ventas_transacciones.ventasDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepuestoDTO {
    private Integer idRepuesto;
    private String nombreRepuesto;
    private Double precio;
    @JsonProperty("cantidadRepuesto")
    private Integer stock; // Es importante validar el stock antes de vender

    // Constructor vacío (necesario para que Spring/Jackson funcione)
    public RepuestoDTO() {}

    // Getters y Setters
    public Integer getIdRepuesto() { return idRepuesto; }
    public void setIdRepuesto(Integer idRepuesto) { this.idRepuesto = idRepuesto; }

    public String getNombreRepuesto() { return nombreRepuesto; }
    public void setNombreRepuesto(String nombreRepuesto) { this.nombreRepuesto = nombreRepuesto; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}