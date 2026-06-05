package com.todoautos.proveedores.entity;

//import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;

@Entity
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idDetalleCompra;
    private String detalleCompra;

// @OneToMany(mappedBy = "detalleCompra")
// private List<OrdenCompra> ordenCompras;

public DetalleCompra() {
    this.detalleCompra="";
}

public Integer getIdDetalleCompra() {
    return idDetalleCompra;
}

public void setIdDetalleCompra(Integer idDetalleCompra) {
    this.idDetalleCompra = idDetalleCompra;
}

public String getDetalleCompra() {
    return detalleCompra;
}

public void setDetalleCompra(String detalleCompra) {
    this.detalleCompra = detalleCompra;
}

// public List<OrdenCompra> getOrdenCompras() {
//     return ordenCompras;
// }

// public void setOrdenCompras(List<OrdenCompra> ordenCompras) {
//     this.ordenCompras = ordenCompras;
// }

}
