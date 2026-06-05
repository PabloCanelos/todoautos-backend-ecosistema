package com.todoautos.catalogo.entity;

// import java.util.ArrayList;
// import java.util.List;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // <-- Nueva Importación
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;

@Entity
public class CategoriaRepuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String descripcion;

    // Relación: Una categoría tiene muchos repuestos (1:N)
    // @OneToMany(mappedBy = "categoria")
    // @JsonIgnoreProperties("categoria")
    // private List<Repuesto> repuestos;

    public CategoriaRepuesto() {
        this.descripcion = "";
        //this.repuestos = new ArrayList<>();
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//     public List<Repuesto> getRepuestos() {
//         return repuestos;
//     }

//     public void setRepuestos(List<Repuesto> repuestos) {
//         this.repuestos = repuestos;
//     }
 }