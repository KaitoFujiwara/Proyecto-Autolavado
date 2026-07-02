package modelos;

public class Servicio {

    private String idServicio;
    private Auto auto;
    private String tipoServicio;
    private double precio;
    private String fecha;
    private String horaEntrada;
    private String horaSalida;
    private String duracion;
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

        this.horaSalida = "Pendiente";
        this.duracion = "Pendiente";
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return idServicio + " - "
                + auto.getCliente().getNombreCompleto()
                + " - "
                + tipoServicio;
    }
}