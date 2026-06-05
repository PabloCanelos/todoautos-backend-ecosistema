package com.todoautos.usuarios.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombreUsuario;
    private String contraseñaUsuario;

    // USUARIO TIENE UNA RELACION MUCHOS A UNO CON SU PADRE ROL
    @ManyToOne
    @JoinColumn(name = "idRol")//creamos la columna fisica, normalmente le pnemos elmismo nombre del dato id de la otra tabla
    @JsonManagedReference("usuario-rol")
    private Rol rol;//instanciamos a la tabla rol

    public Usuario() {
        this.nombreUsuario = "";
        this.contraseñaUsuario = "";
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }
}