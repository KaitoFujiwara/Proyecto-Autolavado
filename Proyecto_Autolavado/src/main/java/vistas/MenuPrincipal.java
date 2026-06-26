
package vistas;
import controladores.ControladorRegistro;
import controladores.ControladorServicios;

public class MenuPrincipal extends javax.swing.JFrame {
    
    private ControladorRegistro controladorRegistro;
    private ControladorServicios controladorServicios;

    public MenuPrincipal() {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Lava Autos");

    jTabbedPane1.removeAll();

    controladorRegistro = new ControladorRegistro();
    controladorServicios = new ControladorServicios();

    PanelRegistro panelRegistro = new PanelRegistro(controladorRegistro);
    PanelServicios panelServicios = new PanelServicios(controladorRegistro, controladorServicios);
    PanelTicket panelTicket = new PanelTicket(controladorServicios);

    jTabbedPane1.addTab("Registro", panelRegistro);
    jTabbedPane1.addTab("Servicio", panelServicios);
    jTabbedPane1.addTab("Ticket", panelTicket);
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
