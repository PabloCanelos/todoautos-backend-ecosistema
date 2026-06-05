package com.todoautos.clientes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente; 

    private String rutCliente;
    private String primerNombreCliente;
    private String segundoNombreCliente;
    private String primerApellidoCliente;
    private String segundoApellidoCliente;
    private Integer telefonoCliente;
    private String correoElectronicoCliente;

    public Cliente() {
        this.rutCliente = "";
        this.primerNombreCliente = "";
        this.segundoNombreCliente = "";
        this.primerApellidoCliente = "";
        this.segundoApellidoCliente = "";
        this.telefonoCliente = null;
        this.correoElectronicoCliente = "";
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getPrimerNombreCliente() {
        return primerNombreCliente;
    }

    public void setPrimerNombreCliente(String primerNombreCliente) {
        this.primerNombreCliente = primerNombreCliente;
    }

    public String getSegundoNombreCliente() {
        return segundoNombreCliente;
    }

    public void setSegundoNombreCliente(String segundoNombreCliente) {
        this.segundoNombreCliente = segundoNombreCliente;
    }

    public String getPrimerApellidoCliente() {
        return primerApellidoCliente;
    }

    public void setPrimerApellidoCliente(String primerApellidoCliente) {
        this.primerApellidoCliente = primerApellidoCliente;
    }

    public String getSegundoApellidoCliente() {
        return segundoApellidoCliente;
    }

    public void setSegundoApellidoCliente(String segundoApellidoCliente) {
        this.segundoApellidoCliente = segundoApellidoCliente;
    }

    public Integer getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(Integer telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoElectronicoCliente() {
        return correoElectronicoCliente;
    }

    public void setCorreoElectronicoCliente(String correoElectronicoCliente) {
        this.correoElectronicoCliente = correoElectronicoCliente;
    }
}