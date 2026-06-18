package com.example.ms_movimientos_inventario.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TipoMovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMovimientoInventario; // Corregido el nombre (Typo en ID)

    private String tipoMovimientoInventario;

    @JsonIgnore // Evita bucle infinito en JSON
    @OneToMany(mappedBy = "tipoMovimiento", cascade = CascadeType.ALL)
    private List<MovimientoInventario> movimientos = new ArrayList<>();

    public TipoMovimientoInventario() {}

    // Getters y Setters
    public Integer getIdTipoMovimientoInventario() { return idTipoMovimientoInventario; }
    public void setIdTipoMovimientoInventario(Integer idTipoMovimientoInventario) { this.idTipoMovimientoInventario = idTipoMovimientoInventario; }

    public String getTipoMovimientoInventario() { return tipoMovimientoInventario; }
    public void setTipoMovimientoInventario(String tipoMovimientoInventario) { this.tipoMovimientoInventario = tipoMovimientoInventario; }

    public List<MovimientoInventario> getMovimientos() { return movimientos; }
    public void setMovimientos(List<MovimientoInventario> movimientos) { this.movimientos = movimientos; }
}