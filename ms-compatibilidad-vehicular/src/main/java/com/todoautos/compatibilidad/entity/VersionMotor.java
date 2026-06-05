package com.todoautos.compatibilidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class VersionMotor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVersionMotor; // [cite: 71]
    private String descripcionVersionMotor; // [cite: 72]

    public VersionMotor() {
        this.descripcionVersionMotor = "";
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




    //un modelo puede tener una marca
    // @ManyToOne
    // @JoinColumn(name = "idModeloVehiculo")
    // @JsonBackReference
    // private ModeloVehiculo modeloVehiculo; //

    // //una version de motor puede tener compatibilidad con diferentes vehiculos
    // @OneToMany(mappedBy = "versionMotor")
    // @JsonManagedReference
    // private List<Compatibilidad> compatibilidades; //



    // public ModeloVehiculo getModeloVehiculo() {
    //     return modeloVehiculo;
    // }

    // public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
    //     this.modeloVehiculo = modeloVehiculo;
    // }

    // public List<Compatibilidad> getCompatibilidades() {
    //     return compatibilidades;
    // }

    // public void setCompatibilidades(List<Compatibilidad> compatibilidades) {
    //     this.compatibilidades = compatibilidades;
    // }



}