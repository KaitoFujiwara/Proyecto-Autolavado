package modelos;

import modelos.Auto;

public class Servicio {

    private String idServicio;
    private Auto auto;
    private String tipoServicio;
    private double precio;
    private String fecha;
    private String horaEntrada;
    private String metodoPago;

    public Servicio(String idServicio, Auto auto, String tipoServicio, double precio,
            String fecha, String horaEntrada, String metodoPago) {

        this.idServicio = idServicio;
        this.auto = auto;
        this.tipoServicio = tipoServicio;
        this.precio = precio;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.metodoPago = metodoPago;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public Auto getAuto() {
        return auto;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    @Override
    public String toString() {
        return idServicio + " - " + tipoServicio;
    }
}