package controladores;

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

    public Servicio[] getServicios() {
        return servicios;
    }

    public int getContadorServicios() {
        return contadorServicios;
    }
}