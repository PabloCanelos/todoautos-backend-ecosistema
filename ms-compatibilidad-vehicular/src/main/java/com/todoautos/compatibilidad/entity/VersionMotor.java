package com.todoautos.compatibilidad.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class VersionMotor {

    // 1. CAMPOS (Campos de ID, luego datos, luego relaciones)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVersionMotor;

    private String descripcionVersionMotor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModeloVehiculo", nullable = false)
    @JsonBackReference
    private ModeloVehiculo modeloVehiculo;

    @OneToMany(mappedBy = "versionMotor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Compatibilidad> compatibilidades = new ArrayList<>();

    // 2. CONSTRUCTOR
    public VersionMotor() {
        this.descripcionVersionMotor = "";
    }

    // 3. MÉTODO HELPER (Lógica de relación)
    public void addCompatibilidad(Compatibilidad compatibilidad) {
        this.compatibilidades.add(compatibilidad);
        compatibilidad.setVersionMotor(this);
    }

    public Integer getIdVersionMotor() {
        return idVersionMotor;
    }
    public void setIdVersionMotor(Integer idVersionMotor) {
        this.idVersionMotor = idVersionMotor;
    }

    public String getDescripcionVersionMotor() {
        return descripcionVersionMotor;
    }
    public void setDescripcionVersionMotor(String descripcionVersionMotor) {
        this.descripcionVersionMotor = descripcionVersionMotor;
    }

    public ModeloVehiculo getModeloVehiculo() {
        return modeloVehiculo;
    }
    public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
         this.modeloVehiculo = modeloVehiculo;
        }

    public List<Compatibilidad> getCompatibilidades() {
        return compatibilidades;
    }
    public void setCompatibilidades(List<Compatibilidad> compatibilidades) {
        this.compatibilidades = compatibilidades;
    }
}