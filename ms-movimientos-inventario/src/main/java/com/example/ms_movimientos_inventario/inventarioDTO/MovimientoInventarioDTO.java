package com.example.ms_movimientos_inventario.inventarioDTO;

public class MovimientoInventarioDTO {

    private Integer idRepuesto;
    private int cantidadMovimientoInventario;
    private Integer idTipoMovimiento;

    // Constructor vacío
    public MovimientoInventarioDTO() {}

    // GETTERS (Aquí está la solución a tus errores)
    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public int getCantidadMovimientoInventario() {
        return cantidadMovimientoInventario;
    }

    public Integer getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    // SETTERS (Necesarios si vas a recibir datos desde otro MS)
    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public void setCantidadMovimientoInventario(int cantidadMovimientoInventario) {
        this.cantidadMovimientoInventario = cantidadMovimientoInventario;
    }

    public void setIdTipoMovimiento(Integer idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }
}