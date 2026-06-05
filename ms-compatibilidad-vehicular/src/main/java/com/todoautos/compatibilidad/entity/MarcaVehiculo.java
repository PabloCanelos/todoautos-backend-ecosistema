package com.todoautos.compatibilidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MarcaVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarcaVehiculo;
    private String nombreMarcaVehiculo;


    // RELACIÓN: Una Marca tiene muchos Modelos
    // @OneToMany(mappedBy = "marcaVehiculo")
    // @JsonManagedReference
    // private List<ModeloVehiculo> modelos;
    public MarcaVehiculo() {
        this.nombreMarcaVehiculo ="";

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



}
