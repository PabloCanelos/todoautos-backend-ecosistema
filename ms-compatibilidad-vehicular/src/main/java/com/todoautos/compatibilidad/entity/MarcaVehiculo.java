package com.todoautos.compatibilidad.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class MarcaVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarcaVehiculo;
    private String nombreMarcaVehiculo;


    //RELACIÓN: Una Marca tiene muchos Modelos
    @OneToMany(mappedBy = "marcaVehiculo", cascade= CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="marca-modelo")
    private List<ModeloVehiculo> modelos = new ArrayList<>();
    public MarcaVehiculo() {
        this.nombreMarcaVehiculo ="";

    }
    // MÉTODO HELPER (Garantiza la sincronización bidireccional)
    public void addModelo(ModeloVehiculo modelo) {
        this.modelos.add(modelo);
        modelo.setMarcaVehiculo(this);
    }

    public Integer getIdMarcaVehiculo() {
        return idMarcaVehiculo;
    }

    public void setIdMarcaVehiculo(Integer idMarcaVehiculo) {
        this.idMarcaVehiculo = idMarcaVehiculo;
    }

    public String getNombreMarcaVehiculo() {
        return nombreMarcaVehiculo;
    }

    public void setNombreMarcaVehiculo(String nombreMarcaVehiculo) {
        this.nombreMarcaVehiculo = nombreMarcaVehiculo;
    }
    public List<ModeloVehiculo> getModelos() {
        return modelos;
    }
    public void setModelos(List<ModeloVehiculo> modelos) {
        this.modelos = modelos;
    }




}
