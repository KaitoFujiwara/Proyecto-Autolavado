import vistas.Proyecto;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Proyecto().setVisible(true);
        });
    }
}