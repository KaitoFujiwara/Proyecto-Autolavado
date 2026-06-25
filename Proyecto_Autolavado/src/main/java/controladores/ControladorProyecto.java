package controladores;

import java.util.ArrayList;
import modelos.Auto;
import modelos.Cliente;
import modelos.Reservacion;
import modelos.Servicio;
import vistas.Proyecto;

public class ControladorProyecto {

    private Proyecto vista;

    private ArrayList<Cliente> clientes;
    private ArrayList<Auto> autos;
    private ArrayList<Servicio> servicios;
    private ArrayList<Reservacion> reservaciones;

    public ControladorProyecto(Proyecto vista) {
        this.vista = vista;
        this.clientes = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.reservaciones = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarAuto(Auto auto) {
        autos.add(auto);
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public void agregarReservacion(Reservacion reservacion) {
        reservaciones.add(reservacion);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Reservacion> getReservaciones() {
        return reservaciones;
    }
    public Cliente buscarCliente(int id) {
    for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
            return cliente;
        }
    }
    return null;
}

public Auto buscarAuto(int id) {
    for (Auto auto : autos) {
        if (auto.getId() == id) {
            return auto;
        }
    }
    return null;
}

public Servicio buscarServicio(int id) {
    for (Servicio servicio : servicios) {
        if (servicio.getId() == id) {
            return servicio;
        }
    }
    return null;
}

public Reservacion buscarReservacion(int id) {
    for (Reservacion reservacion : reservaciones) {
        if (reservacion.getId() == id) {
            return reservacion;
        }
    }
    return null;
}
}