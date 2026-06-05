package com.todoautos.proveedores.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Entity
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    // @ManyToOne
    // @JoinColumn(name="rutProveedor")
    // private Proveedor proveedor;

    // @ManyToOne
    // @JoinColumn(name="idDetalleCompra")
    // private DetalleCompra detalleCompra;

    public OrdenCompra() {
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }



}
