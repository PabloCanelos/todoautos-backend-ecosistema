package com.todoautos.compatibilidad.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
@Entity
public class ModeloVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModeloVehiculo;
    private String nombreModeloVehiculo;


    //modelo vehiculo es hijo de MARCA-VEHICULO
    // @ManyToOne
    // @JoinColumn(name = "idMarcaVehiculo")
    // @JsonBackReference
    // private MarcaVehiculo marcaVehiculo;


    // //modelo vehiculo es padre de version motor
    // @OneToMany(mappedBy = "modeloVehiculo")
    // @JsonManagedReference
    // private List<VersionMotor> versionesMotor;
    //     public ModeloVehiculo() {
    //         this.nombreModeloVehiculo="";
    //         this.versionesMotor = new ArrayList<>();
    //     }


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


}
