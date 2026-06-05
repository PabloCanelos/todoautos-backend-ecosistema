package com.todoautos.devoluciones.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity
public class DevolucionProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDevolucionProveedor;

    private LocalDate fechaDevolucionProveedor;

    // @OneToMany(mappedBy = "devProveedor")
    // private List<Devolucion> devoluciones;

    public DevolucionProveedor() {}

    public Integer getIdDevolucionProveedor() {
        return idDevolucionProveedor;
    }

    public void setIdDevolucionProveedor(Integer idDevolucionProveedor) {
        this.idDevolucionProveedor = idDevolucionProveedor;
    }

    public LocalDate getFechaDevolucionProveedor() {
        return fechaDevolucionProveedor;
    }

    public void setFechaDevolucionProveedor(LocalDate fechaDevolucionProveedor) {
        this.fechaDevolucionProveedor = fechaDevolucionProveedor;
    }

    // public List<Devolucion> getDevoluciones() {
    //     return devoluciones;
    // }

    // public void setDevoluciones(List<Devolucion> devoluciones) {
    //     this.devoluciones = devoluciones;
    // }
}
