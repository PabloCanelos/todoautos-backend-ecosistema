package com.example.ms_ventas_transacciones.ventasDTO;

public class ClienteDTO {

    private String rutCliente;
    private String primerNombreCliente;
    private String primerApellidoCliente;

    // Constructor vacío (necesario para que RestTemplate pueda crear el objeto)
    public ClienteDTO() {
    }

    // Getters y Setters (obligatorios para que Spring pueda asignar los valores)
    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getPrimerNombreCliente() {
        return primerNombreCliente;
    }

    public void setPrimerNombreCliente(String primerNombreCliente) {
        this.primerNombreCliente = primerNombreCliente;
    }

    public String getPrimerApellidoCliente() {
        return primerApellidoCliente;
    }

    public void setPrimerApellidoCliente(String primerApellidoCliente) {
        this.primerApellidoCliente = primerApellidoCliente;
    }
}