package com.example.ms_bodega_ubicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BodegaUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUbicacionBodega;
    private String piso;
    private String pasillo;
    private String estante;
    private String nivelEstante;


    public BodegaUbicacion() {

        this.piso = "";
        this.pasillo = "";
        this.estante = "";
        this.nivelEstante = "";
    }


    public Integer getIdUbicacionBodega() {
        return idUbicacionBodega;
    }


    public void setIdUbicacionBodega(Integer idUbicacionBodega) {
        this.idUbicacionBodega = idUbicacionBodega;
    }


    public String getPiso() {
        return piso;
    }


    public void setPiso(String piso) {
        this.piso = piso;
    }


    public String getPasillo() {
        return pasillo;
    }


    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }


    public String getEstante() {
        return estante;
    }


    public void setEstante(String estante) {
        this.estante = estante;
    }


    public String getNivelEstante() {
        return nivelEstante;
    }


    public void setNivelEstante(String nivelEstante) {
        this.nivelEstante = nivelEstante;
    }

    
}
