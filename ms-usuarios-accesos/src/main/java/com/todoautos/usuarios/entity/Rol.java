package com.todoautos.usuarios.entity;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idRol;
    private String nombreRol;


    //relcion con usuario, un rol puede pertenecer a muchos usuarios, pero cada usuario solo un rol
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios = new ArrayList<>();

     // rol tiene una relacion many to many con permiso
     //esta seria la tabla principal la que abre la relacion, una debe tener el control
    @ManyToMany
    @JoinTable(
        // defino un nombre para la tabla intermedia(implicita) de la relacion,
         // esta tabla se creara automaticamente en la base de datos
         name = "PermisoRol",
         joinColumns = @JoinColumn(name = "idRol"),//(hago el join con el id de la entidad principal que seria esta misma )
         inverseJoinColumns = @JoinColumn(name = "idPermiso")// inverse join argumento id de la entidad //relacionada
     )
    @JsonManagedReference("rol-permiso") // <-- Se vincula con el mismo nombre de Permiso
    private List<Permiso> permisos;//esta lista creada servira para alimentar de informacion a la tabla relacionada


    public Rol() {
        this.nombreRol = "";
        this.permisos = new ArrayList<>();
    }

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