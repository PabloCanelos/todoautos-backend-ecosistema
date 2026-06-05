package com.todoautos.usuarios.entity;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermiso;
    private String nombrePermiso;
    private String descripcionPermiso;

    //RELACION MUCHOS A MUCHOS CON ROL
    @ManyToMany(mappedBy = "permisos")//<-- permisos es el nombre que le pondre a la lista en la clase rol
    @JsonBackReference("rol-permiso") // <-- Se le agrega el identificador que define la tabla intermedia implicita
    private List<Rol> roles;// esta lista contendra la lista de roles

    public Permiso() {
        this.nombrePermiso = "";
        this.descripcionPermiso = "";
        this.roles = new ArrayList<>();
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    public List<Rol> getRoles() {
         return roles;
     }

    public void setRoles(List<Rol> roles) {
         this.roles = roles;
    }
}