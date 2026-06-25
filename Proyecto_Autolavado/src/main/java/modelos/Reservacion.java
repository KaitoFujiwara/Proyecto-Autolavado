package modelos;

import java.time.LocalDateTime;

public class Reservacion {

    private int id;
    private Cliente cliente;
    private Auto auto;
    private Servicio servicio;
    private LocalDateTime fechaEntrega;
    private double total;
    private String tipoPago;

    public Reservacion() {
    }

    public Reservacion(int id, Cliente cliente, Auto auto, Servicio servicio,
            LocalDateTime fechaEntrega, double total, String tipoPago) {

        this.id = id;
        this.cliente = cliente;
        this.auto = auto;
        this.servicio = servicio;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.tipoPago = tipoPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Reservación " + id;
    }
}