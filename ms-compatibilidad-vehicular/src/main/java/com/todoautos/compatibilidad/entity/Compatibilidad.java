package com.todoautos.compatibilidad.entity;
//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

@Entity
public class Compatibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCompatibilidad;
    private Integer annioInicio;
    private Integer annioTermino;
    private String observaciones;
    private Integer repuestoId;


    // //relacion vrsion motor hija de compatibilidad
    // @ManyToOne
    // @JoinColumn(name = "idVersionMotor")
    // @JsonBackReference
    // private VersionMotor versionMotor;


    public Compatibilidad() {
        this.annioInicio =0;
        this.annioTermino =0;
        this.observaciones ="";
        this.repuestoId = 0;
    }

    public Integer getIdCompatibilidad() {
        return idCompatibilidad;
    }


    public void setIdCompatibilidad(Integer idCompatibilidad) {
        this.idCompatibilidad = idCompatibilidad;
    }

    public Integer getAnnioInicio() {
        return annioInicio;
    }

    public void setAnnioInicio(Integer annioInicio) {
        this.annioInicio = annioInicio;
    }

    public Integer getAnnioTermino() {
        return annioTermino;
    }

    public void setAnnioTermino(Integer annioTermino) {
        this.annioTermino = annioTermino;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getRepuestoId() {
        return repuestoId;
    }

    public void setRepuestoId(Integer repuestoId) {
        this.repuestoId = repuestoId;
    }







}






