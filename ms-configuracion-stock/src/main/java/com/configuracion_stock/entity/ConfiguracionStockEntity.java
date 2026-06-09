package com.configuracion_stock.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ConfiguracionStockEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idConfiguracion;

    private Integer stockMinimo;

    private Integer stockMaximo;
    private String observaciones;
    //importacion
    private Integer repuestoId;

    public ConfiguracionStockEntity() {
        this.stockMinimo =0;
        this.stockMaximo =0;
        this.observaciones ="";
    }


    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }


    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }


    public Integer getStockMinimo() {
        return stockMinimo;
    }


    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }


    public Integer getStockMaximo() {
        return stockMaximo;
    }


    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }


    public String getObservaciones() {
        return observaciones;
    }


    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public Integer getRepuestoId() {
        return repuestoId;
    }


    public void setRepuestoId(Integer repuestoId) {
        this.repuestoId = repuestoId;
    }






}
