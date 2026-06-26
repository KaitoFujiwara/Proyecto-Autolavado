package controladores;

import modelos.Auto;
import modelos.Cliente;

public class ControladorRegistro {

    private Cliente[] clientes;
    private Auto[] autos;
    private int contadorClientes;
    private int contadorAutos;

    public ControladorRegistro() {
        clientes = new Cliente[100];
        autos = new Auto[100];
        contadorClientes = 0;
        contadorAutos = 0;
    }

    public String generarIdAuto() {
        return String.format("AUT-%04d", contadorAutos + 1);
    }

    public boolean registrarClienteAuto(String nombre, String apellidoPaterno,
        String apellidoMaterno, String telefono,
        String color, String marca, String modelo) {

    if (contadorClientes < clientes.length && contadorAutos < autos.length) {

        Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, telefono);

        String idAuto = generarIdAuto();

        Auto auto = new Auto(idAuto, color, marca, modelo, cliente);

        clientes[contadorClientes] = cliente;
        autos[contadorAutos] = auto;

        contadorClientes++;
        contadorAutos++;

        return true;
    }

    return false;
}

    public Cliente obtenerCliente(int posicion) {
        if (posicion >= 0 && posicion < contadorClientes) {
            return clientes[posicion];
        }
        return null;
    }

    public Auto obtenerAuto(int posicion) {
        if (posicion >= 0 && posicion < contadorAutos) {
            return autos[posicion];
        }
        return null;
    }

    public Auto buscarAutoPorId(String idAuto) {
        for (int i = 0; i < contadorAutos; i++) {
            if (autos[i].getIdAuto().equals(idAuto)) {
                return autos[i];
            }
        }
        return null;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public Auto[] getAutos() {
        return autos;
    }

    public int getContadorClientes() {
        return contadorClientes;
    }

    public int getContadorAutos() {
        return contadorAutos;
    }
}
