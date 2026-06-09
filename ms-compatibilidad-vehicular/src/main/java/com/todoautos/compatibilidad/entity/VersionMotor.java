package com.todoautos.compatibilidad.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class VersionMotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVersionMotor;

    private String descripcionVersionMotor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModeloVehiculo", nullable = false)
    @JsonBackReference(value = "modelo-version") // CORREGIDO: Debe coincidir con ModeloVehiculo
    private ModeloVehiculo modeloVehiculo;

    @OneToMany(mappedBy = "versionMotor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "version-compatibilidad")
    private List<Compatibilidad> compatibilidades = new ArrayList<>();

    public VersionMotor() {
        this.descripcionVersionMotor = "";
    }

    // MÉTODO HELPER
    public void addCompatibilidad(Compatibilidad compatibilidad) {
        this.compatibilidades.add(compatibilidad);
        compatibilidad.setVersionMotor(this);
    }

    // Getters y Setters
    public Integer getIdVersionMotor() { return idVersionMotor; }
    public void setIdVersionMotor(Integer idVersionMotor) { this.idVersionMotor = idVersionMotor; }
    public String getDescripcionVersionMotor() { return descripcionVersionMotor; }
    public void setDescripcionVersionMotor(String descripcionVersionMotor) { this.descripcionVersionMotor = descripcionVersionMotor; }
    public ModeloVehiculo getModeloVehiculo() { return modeloVehiculo; }
    public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) { this.modeloVehiculo = modeloVehiculo; }
    public List<Compatibilidad> getCompatibilidades() { return compatibilidades; }
    public void setCompatibilidades(List<Compatibilidad> compatibilidades) { this.compatibilidades = compatibilidades; }
}