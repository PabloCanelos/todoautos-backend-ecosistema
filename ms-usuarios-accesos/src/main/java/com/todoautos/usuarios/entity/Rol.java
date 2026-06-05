package com.todoautos.usuarios.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String nombreRol;

    // RELACIÓN UNO A MUCHOS CON USUARIO (Un rol, muchos usuarios)
    // El espejo 'mappedBy' apunta al atributo 'rol' de la clase Usuario
    @OneToMany(mappedBy = "rol")
    @JsonIgnoreProperties("rol")
    private List<Usuario> usuarios = new ArrayList<>();

    // RELACIÓN MUCHOS A MUCHOS CON PERMISO
    // Esta es la entidad principal que es dueña de la relación con Permiso
    @ManyToMany
    @JoinTable(
        name = "PermisoRol", // Nombre de la tabla intermedia implícita en MySQL
        joinColumns = @JoinColumn(name = "idRol"), // FK de esta entidad principal (Rol)
        inverseJoinColumns = @JoinColumn(name = "idPermiso") // FK de la entidad relacionada (Permiso)
    )
    @JsonIgnoreProperties("roles") // Evita el bucle infinito de Jackson
    private List<Permiso> permisos = new ArrayList<>(); // Alimenta de información a la tabla relacionada

    // Constructor Vacío Profesional
    public Rol() {
        this.nombreRol = "";
        this.permisos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // --- GETTERS Y SETTERS ---

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}