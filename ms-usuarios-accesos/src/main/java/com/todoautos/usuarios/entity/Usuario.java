package com.todoautos.usuarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    // UN USUARIO TIENE UN ÚNICO ROL (Muchos a Uno)
    @ManyToOne
    @JoinColumn(name = "id_rol") // Crea la FK id_rol físicamente en la tabla Usuario
    @JsonIgnoreProperties("usuarios") // Evita el bucle infinito en Jackson
    private Rol rol; // Un solo objeto Rol, no una lista

    public Usuario() {
        this.nombreUsuario = "";
        this.contraseñaUsuario = "";
    }

    // --- GETTERS Y SETTERS ---

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}