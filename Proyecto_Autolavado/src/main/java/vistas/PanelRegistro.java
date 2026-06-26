package vistas;
import controladores.ControladorRegistro;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Auto;

public class PanelRegistro extends javax.swing.JPanel {
    private ControladorRegistro controlador;
    private DefaultTableModel modeloTabla;
    
 public PanelRegistro(ControladorRegistro controlador) {
    initComponents();

    this.controlador = controlador;

    modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("ID Auto");
    modeloTabla.addColumn("Cliente");
    modeloTabla.addColumn("Teléfono");
    modeloTabla.addColumn("Color");
    modeloTabla.addColumn("Marca");
    modeloTabla.addColumn("Modelo");

    tablaRegistro.setModel(modeloTabla);

    txtIdAuto.setEditable(false);
    txtIdAuto.setText(controlador.generarIdAuto());
}

private void limpiarCampos() {
    txtNombre.setText("");
    txtTelefono.setText("");
    txtColor.setText("");
    txtMarca.setText("");
    txtModelo.setText("");

    txtIdAuto.setText(controlador.generarIdAuto());
    txtNombre.requestFocus();
}

private boolean esNumero(String texto) {
    try {
        Double.parseDouble(texto);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

private void mostrarRegistros() {
    modeloTabla.setRowCount(0);

    for (int i = 0; i < controlador.getContadorAutos(); i++) {
        Auto auto = controlador.obtenerAuto(i);

        Object[] fila = {auto.getIdAuto(),auto.getCliente().getNombre(),auto.getCliente().getTelefono(),auto.getColor(),auto.getMarca(),auto.getModelo()
        };

        modeloTabla.addRow(fila);
    }
}

private boolean soloLetrasYEspacios(String texto) {
    return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
}

private boolean soloNumeros(String texto) {
    return texto.matches("[0-9]+");
}

private boolean letrasNumerosYEspacios(String texto) {
    return texto.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+");
}

    private void guardarRegistro() {
    String nombre = txtNombre.getText();
    String telefono = txtTelefono.getText();
    String color = txtColor.getText();
    String marca = txtMarca.getText();
    String modelo = txtModelo.getText();

    if (nombre.equals("") || telefono.equals("") || color.equals("")
            || marca.equals("") || modelo.equals("")) {

        JOptionPane.showMessageDialog(this, "No puedes dejar campos vacíos");
        return;
    }

    if (!soloLetrasYEspacios(nombre)) {
        JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras, sin números ni signos");
        return;
    }

    if (!soloNumeros(telefono)) {
        JOptionPane.showMessageDialog(this, "El teléfono debe contener solo números");
        return;
    }

    if (telefono.length() != 10) {
        JOptionPane.showMessageDialog(this, "El teléfono debe tener exactamente 10 dígitos");
        return;
    }

    if (!soloLetrasYEspacios(color)) {
        JOptionPane.showMessageDialog(this, "El color solo debe contener letras, sin números ni signos");
        return;
    }

    if (!soloLetrasYEspacios(marca)) {
        JOptionPane.showMessageDialog(this, "La marca solo debe contener letras, sin números ni signos");
        return;
    }

    if (!letrasNumerosYEspacios(modelo)) {
        JOptionPane.showMessageDialog(this, "El modelo no debe contener signos");
        return;
    }

    boolean guardado = controlador.registrarClienteAuto(nombre,telefono,color,marca,modelo);

    if (guardado) {
        JOptionPane.showMessageDialog(this, "Registro guardado correctamente");
        mostrarRegistros();
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "No hay espacio para más registros");
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdAuto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnGuardarRegistro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel1.setText("LAVA-AUTOS  RUST-EZE");

        jLabel2.setText("Nombre:");

        txtNombre.addActionListener(this::txtNombreActionPerformed);

        jLabel3.setText("Telefono:");

        jLabel4.setText("Registro de Cliente");

        jLabel5.setText("Registro de Auto");

        jLabel6.setText("ID auto:");

        txtIdAuto.setEditable(false);

        jLabel7.setText("Color:");

        jLabel8.setText("Marca:");

        jLabel9.setText("Modelo:");

        btnGuardarRegistro.setText("Guardar Registros");
        btnGuardarRegistro.addActionListener(this::btnGuardarRegistroActionPerformed);

        tablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaRegistro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(txtIdAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtColor)
                                        .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardarRegistro)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnGuardarRegistro)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        // TODO add your handling code here:
        guardarRegistro();
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRegistro;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtIdAuto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
