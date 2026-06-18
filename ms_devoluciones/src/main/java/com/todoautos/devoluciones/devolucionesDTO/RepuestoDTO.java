package com.todoautos.devoluciones.devolucionesDTO;

public class RepuestoDTO {

    private Integer id;
    private String nombre;
    private Integer stock;
    private Double precio;
    private Integer idCategoria;

    // Constructor vacío (necesario para que RestTemplate convierta el JSON)
    public RepuestoDTO() {
    }

    // Constructor con parámetros
    public RepuestoDTO(Integer id, String nombre, Integer stock, Double precio, Integer idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.idCategoria = idCategoria;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
}