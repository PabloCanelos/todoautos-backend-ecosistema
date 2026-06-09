package com.todoautos.compatibilidad.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "compatibilidad")
public class Compatibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompatibilidad;

    private Integer annioInicio;
    private Integer annioTermino;
    private String observaciones;
    private Integer repuestoId;

    // Relación: Muchas compatibilidades pertenecen a una sola versión de motor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVersionMotor", nullable = false)
    @JsonBackReference(value = "version-compatibilidad")
    private VersionMotor versionMotor;

    public Compatibilidad() {
        this.annioInicio = 0;
        this.annioTermino = 0;
        this.observaciones = "";
        this.repuestoId = 0;
    }

    // Getters y Setters
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

    public VersionMotor getVersionMotor() {
        return versionMotor;
    }

    public void setVersionMotor(VersionMotor versionMotor) {
        this.versionMotor = versionMotor;
    }
}