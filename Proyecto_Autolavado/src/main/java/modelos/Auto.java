package modelos;

public class Auto {

    private String idAuto;
    private String color;
    private String marca;
    private String modelo;
    private Cliente cliente;

    public Auto(String idAuto, String color, String marca, String modelo, Cliente cliente) {
        this.idAuto = idAuto;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return idAuto + " - " + marca + " " + modelo + " (" + color + ")";
    }
}