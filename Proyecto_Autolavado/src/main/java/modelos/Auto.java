package modelos;

public class Auto {

    private int id;
    private String color;
    private String modelo;

    public Auto() {
    }

    public Auto(int id, String color, String modelo) {
        this.id = id;
        this.color = color;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return modelo;
    }
}