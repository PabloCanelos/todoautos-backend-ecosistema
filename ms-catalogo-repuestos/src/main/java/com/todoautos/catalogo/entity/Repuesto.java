package com.todoautos.catalogo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRepuesto;
    private String nombreRepuesto;
    private String descripcionRepuesto;
    private Double precioVentaRepuesto;
    private Integer cantidadRepuesto;

    // Relación: Muchos repuestos pertenecen a una categoría
    // Agregar fetch = FetchType.LAZY para evitar cargar la categoría siempre
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="idCategoria", nullable = false)// Obliga a que siempre haya una categoría
    @JsonIgnoreProperties("repuestos")
    private CategoriaRepuesto categoria;

    public Repuesto() {
        this.nombreRepuesto = "";
        this.descripcionRepuesto = "";
        this.precioVentaRepuesto = 0.0;
        this.cantidadRepuesto = 0;
    }

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public Double getPrecioVentaRepuesto() {
        return precioVentaRepuesto;
    }

    public void setPrecioVentaRepuesto(Double precioVentaRepuesto) {
        this.precioVentaRepuesto = precioVentaRepuesto;
    }

    public Integer getCantidadRepuesto() {
        return cantidadRepuesto;
    }

    public void setCantidadRepuesto(Integer cantidadRepuesto) {
        this.cantidadRepuesto = cantidadRepuesto;
    }

    public CategoriaRepuesto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRepuesto categoria) {
        this.categoria = categoria;
    }
}