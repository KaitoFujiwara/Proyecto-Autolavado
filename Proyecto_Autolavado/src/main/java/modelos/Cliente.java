package modelos;

import java.util.ArrayList;

public class Cliente {

    private int id;
    private String nombre;
    private String telefono;
    private ArrayList<Auto> autos;

    public Cliente() {
        autos = new ArrayList<>();
    }

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.autos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void setAutos(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public void agregarAuto(Auto auto) {
        autos.add(auto);
    }

    @Override
    public String toString() {
        return nombre;
    }
}