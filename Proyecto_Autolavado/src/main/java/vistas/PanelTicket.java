
package vistas;
import controladores.ControladorServicios;
import javax.swing.JOptionPane;
import modelos.Servicio;

public class PanelTicket extends javax.swing.JPanel {

    private ControladorServicios controladorServicios;
    
    public PanelTicket(ControladorServicios controladorServicios) {
    initComponents();

    this.controladorServicios = controladorServicios;

    txtTicket.setEditable(false);
}
    
   private void buscarServicio() {
    String idServicio = txtBuscarServicio.getText();

    if (idServicio.equals("")) {
        JOptionPane.showMessageDialog(this, "Debes escribir el ID del servicio");
        return;
    }

    Servicio servicio = controladorServicios.buscarServicioPorId(idServicio);

    if (servicio == null) {
        JOptionPane.showMessageDialog(this, "No existe un servicio con ese ID");
        txtTicket.setText("");
        return;
    }

    generarTicket(servicio);
}

private void generarTicket(Servicio servicio) {
    String ticket = "";

    ticket += "====================================\n";
    ticket += "        LAVA AUTOS RUST-EZE\n";
    ticket += "====================================\n";
    ticket += "ID Servicio: " + servicio.getIdServicio() + "\n";
    ticket += "------------------------------------\n";

    ticket += "DATOS DEL CLIENTE\n";
    ticket += "Cliente: " + servicio.getAuto().getCliente().getNombreCompleto() + "\n";
    ticket += "Telefono: " + servicio.getAuto().getCliente().getTelefono() + "\n";
    ticket += "------------------------------------\n";

    ticket += "DATOS DEL AUTO\n";
    ticket += "ID Auto: " + servicio.getAuto().getIdAuto() + "\n";
    ticket += "Auto: " + servicio.getAuto().getMarca() + " " + servicio.getAuto().getModelo() + "\n";
    ticket += "Color: " + servicio.getAuto().getColor() + "\n";
    ticket += "------------------------------------\n";

    ticket += "DATOS DEL SERVICIO\n";
    ticket += "Servicio: " + servicio.getTipoServicio() + "\n";
    ticket += "Precio: $" + servicio.getPrecio() + "\n";
    ticket += "Fecha: " + servicio.getFecha() + "\n";
    ticket += "Hora entrada: " + servicio.getHoraEntrada() + "\n";
    ticket += "Hora salida: " + servicio.getHoraSalida() + "\n";
    ticket += "Duracion: " + servicio.getDuracion() + "\n";
    ticket += "Metodo de pago: " + servicio.getMetodoPago() + "\n";
    ticket += "------------------------------------\n";

    ticket += "TOTAL: $" + servicio.getPrecio() + "\n";
    ticket += "====================================\n";
    ticket += "     Gracias por su preferencia\n";
    ticket += "====================================\n";

    txtTicket.setText(ticket);
}

private void limpiarTicket() {
    txtBuscarServicio.setText("");
    txtTicket.setText("");
    txtBuscarServicio.requestFocus();
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarServicio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("TICKET DE SERVICIO");

        jLabel2.setText("ID Servicio");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane1.setViewportView(txtTicket);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        img.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kaito\\Documents\\NetBeansProjects\\Proyecto-Autolavado\\Proyecto_Autolavado\\src\\main\\java\\vistas\\img\\auto50.jpg")); // NOI18N
        img.setMaximumSize(new java.awt.Dimension(80, 83));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarServicio();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarTicket();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscarServicio;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}
