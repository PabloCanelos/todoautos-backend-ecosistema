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
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ModeloVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModeloVehiculo;
    private String nombreModeloVehiculo;


    //modelo vehiculo es hijo de MARCA-VEHICULO
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idMarcaVehiculo", nullable = false)
    @JsonBackReference(value = "marca-modelo")
    private MarcaVehiculo marcaVehiculo;

    //METODO HELPER PARA INTEGRIDAD


    // //modelo vehiculo es padre de version motor
    @OneToMany(mappedBy = "modeloVehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "modelo-version")
    private List<VersionMotor> versionesMotor= new ArrayList<>();

    public ModeloVehiculo() {
         this.nombreModeloVehiculo="";
        this.versionesMotor = new ArrayList<>();
        }


    public Integer getIdModeloVehiculo() {
        return idModeloVehiculo;
    }

    public void setIdModeloVehiculo(Integer idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }

    public String getNombreModeloVehiculo() {
        return nombreModeloVehiculo;
    }

    public void setNombreModeloVehiculo(String nombreModeloVehiculo) {
        this.nombreModeloVehiculo = nombreModeloVehiculo;
    }


    public MarcaVehiculo getMarcaVehiculo() {
        return marcaVehiculo;
    }


    public void setMarcaVehiculo(MarcaVehiculo marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }


    public List<VersionMotor> getVersionesMotor() {
        return versionesMotor;
    }


    public void setVersionesMotor(List<VersionMotor> versionesMotor) {
        this.versionesMotor = versionesMotor;
    }

     // MÉTODO HELPER para Versiones
    public void addVersionMotor(VersionMotor version) {
        this.versionesMotor.add(version);
        version.setModeloVehiculo(this);
    }



}
