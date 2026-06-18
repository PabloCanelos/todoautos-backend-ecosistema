package com.example.ms_movimientos_inventario.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimientoInventario;

    private Integer idRepuesto; // Identificador del repuesto afectado
    private LocalDate fechaMovimientoInventario;
    private int cantidadMovimientoInventario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento", nullable = false)
    private TipoMovimientoInventario tipoMovimiento;

    public MovimientoInventario() {
        this.fechaMovimientoInventario = LocalDate.now();
        this.cantidadMovimientoInventario = 0;
    }

    // Getters y Setters
    public Integer getIdMovimientoInventario() { return idMovimientoInventario; }
    public void setIdMovimientoInventario(Integer idMovimientoInventario) { this.idMovimientoInventario = idMovimientoInventario; }

    public Integer getIdRepuesto() { return idRepuesto; }
    public void setIdRepuesto(Integer idRepuesto) { this.idRepuesto = idRepuesto; }

    public LocalDate getFechaMovimientoInventario() { return fechaMovimientoInventario; }
    public void setFechaMovimientoInventario(LocalDate fechaMovimientoInventario) { this.fechaMovimientoInventario = fechaMovimientoInventario; }

    public int getCantidadMovimientoInventario() { return cantidadMovimientoInventario; }
    public void setCantidadMovimientoInventario(int cantidadMovimientoInventario) { this.cantidadMovimientoInventario = cantidadMovimientoInventario; }

    public TipoMovimientoInventario getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(TipoMovimientoInventario tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }
}