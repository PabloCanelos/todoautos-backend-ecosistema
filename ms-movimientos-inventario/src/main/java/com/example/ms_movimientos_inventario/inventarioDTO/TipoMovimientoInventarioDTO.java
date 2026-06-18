package com.example.ms_movimientos_inventario.inventarioDTO;

public class TipoMovimientoInventarioDTO {

    private Integer idTipoMovimientoInventario;
    private String tipoMovimientoInventario;

    public TipoMovimientoInventarioDTO() {}

    // Getters
    public Integer getIdTipoMovimientoInventario() {
        return idTipoMovimientoInventario;
    }

    public String getTipoMovimientoInventario() {
        return tipoMovimientoInventario;
    }

    // Setters
    public void setIdTipoMovimientoInventario(Integer idTipoMovimientoInventario) {
        this.idTipoMovimientoInventario = idTipoMovimientoInventario;
    }

    public void setTipoMovimientoInventario(String tipoMovimientoInventario) {
        this.tipoMovimientoInventario = tipoMovimientoInventario;
    }
}