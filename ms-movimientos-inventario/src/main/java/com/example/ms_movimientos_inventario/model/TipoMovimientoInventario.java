package com.example.ms_movimientos_inventario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoMovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMivimientoInventario;
    private String TipoMovimientoInventario;

    public TipoMovimientoInventario() {
        TipoMovimientoInventario = "";
    }

    public Integer getIdTipoMivimientoInventario() {
        return idTipoMivimientoInventario;
    }
    public void setIdTipoMivimientoInventario(Integer idTipoMivimientoInventario) {
        this.idTipoMivimientoInventario = idTipoMivimientoInventario;
    }
    public String getTipoMovimientoInventario() {
        return TipoMovimientoInventario;
    }
    public void setTipoMovimientoInventario(String tipoMovimientoInventario) {
        TipoMovimientoInventario = tipoMovimientoInventario;
    }



}
