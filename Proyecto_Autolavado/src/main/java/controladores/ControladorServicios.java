package controladores;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelos.Servicio;

public class ControladorServicios {

    private Servicio[] servicios;
    private int contadorServicios;

    public ControladorServicios() {
        servicios = new Servicio[100];
        contadorServicios = 0;
    }

    public String generarIdServicio() {
        return String.format("SER-%04d", contadorServicios + 1);
    }

    public boolean agregarServicio(Servicio servicio) {
        if (contadorServicios < servicios.length) {
            servicios[contadorServicios] = servicio;
            contadorServicios++;
            return true;
        }
        return false;
    }

    public Servicio obtenerServicio(int posicion) {
        if (posicion >= 0 && posicion < contadorServicios) {
            return servicios[posicion];
        }
        return null;
    }

    public Servicio buscarServicioPorId(String idServicio) {
        for (int i = 0; i < contadorServicios; i++) {
            if (servicios[i].getIdServicio().equals(idServicio)) {
                return servicios[i];
            }
        }
        return null;
    }

    public boolean registrarSalida(String idServicio) {
        Servicio servicio = buscarServicioPorId(idServicio);

        if (servicio == null) {
            return false;
        }

        if (!servicio.getHoraSalida().equals("Pendiente")) {
            return false;
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime horaSalida = LocalTime.now();
        String horaSalidaTexto = horaSalida.format(formato);

        servicio.setHoraSalida(horaSalidaTexto);

        String duracion = calcularDuracion(servicio.getHoraEntrada(), horaSalidaTexto);
        servicio.setDuracion(duracion);

        return true;
    }

    private String calcularDuracion(String horaEntradaTexto, String horaSalidaTexto) {
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalTime horaEntrada = LocalTime.parse(horaEntradaTexto, formato);
            LocalTime horaSalida = LocalTime.parse(horaSalidaTexto, formato);

            Duration duracion = Duration.between(horaEntrada, horaSalida);

            long horas = duracion.toHours();
            long minutos = duracion.toMinutes() % 60;
            long segundos = duracion.getSeconds() % 60;

            return horas + " h " + minutos + " min " + segundos + " seg";

        } catch (Exception e) {
            return "No calculada";
        }
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public int getContadorServicios() {
        return contadorServicios;
    }
}