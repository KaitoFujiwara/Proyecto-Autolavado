package vistas;

import controladores.ControladorRegistro;
import controladores.ControladorServicios;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Auto;
import modelos.Servicio;

public class PanelServicios extends javax.swing.JPanel {

    private final ControladorRegistro controladorRegistro; 
    private final ControladorServicios controladorServicios;
    private final DefaultTableModel modeloTabla;
    
    public PanelServicios(ControladorRegistro controladorRegistro,
        ControladorServicios controladorServicios) {

    initComponents();

    this.controladorRegistro = controladorRegistro;
    this.controladorServicios = controladorServicios;
    
    Date hoy = new Date();
    dcFecha.setMinSelectableDate(hoy);
    dcFecha.setMaxSelectableDate(hoy);
    dcFecha.setDate(hoy);

    modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("ID Servicio");
    modeloTabla.addColumn("Cliente");
    modeloTabla.addColumn("Auto");
    modeloTabla.addColumn("Servicio");
    modeloTabla.addColumn("Precio");
    modeloTabla.addColumn("Fecha");
    modeloTabla.addColumn("Hora");
    modeloTabla.addColumn("Pago");

    tablaServicios.setModel(modeloTabla);

    txtIdServicio.setEditable(false);
    txtPrecio.setEditable(false);
    txtHoraEntrada.setEditable(false);

    txtIdServicio.setText(controladorServicios.generarIdServicio());

    cargarServiciosOfrecidos();
    cargarMetodosPago();
    cargarAutos();
    actualizarHora();
}

    private void cargarServiciosOfrecidos() {
    cmbServicio.removeAllItems();

    cmbServicio.addItem("Seleccione un servicio");
    cmbServicio.addItem("Lavado Básico");
    cmbServicio.addItem("Lavado Completo");
    cmbServicio.addItem("Encerado");
    cmbServicio.addItem("Lavado de Motor");
    cmbServicio.addItem("Pulido");
}

private void cargarMetodosPago() {
    cmbMetodoPago.removeAllItems();

    cmbMetodoPago.addItem("Seleccione método de pago");
    cmbMetodoPago.addItem("Efectivo");
    cmbMetodoPago.addItem("Tarjeta");
    cmbMetodoPago.addItem("Transferencia");
    cmbMetodoPago.addItem("QR");
}

public void cargarAutos() {
    cmbAutos.removeAllItems();

    cmbAutos.addItem("Seleccione un auto");

    for (int i = 0; i < controladorRegistro.getContadorAutos(); i++) {
        Auto auto = controladorRegistro.obtenerAuto(i);

        cmbAutos.addItem(auto.getIdAuto() + " - "
                + auto.getMarca() + " "
                + auto.getModelo() + " - "
                + auto.getCliente().getNombre());
    }
}

private void actualizarHora() {
    LocalTime horaActual = LocalTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
    txtHoraEntrada.setText(horaActual.format(formato));
}

private double obtenerPrecioServicio(String servicio) {
    if (servicio.equals("Lavado Básico")) {
        return 80;
    } else if (servicio.equals("Lavado Completo")) {
        return 150;
    } else if (servicio.equals("Encerado")) {
        return 200;
    } else if (servicio.equals("Lavado de Motor")) {
        return 250;
    } else if (servicio.equals("Pulido")) {
        return 350;
    } else {
        return 0;
    }
}

private void actualizarPrecio() {
    if (cmbServicio.getSelectedItem() == null) {
        return;
    }

    String servicioSeleccionado = cmbServicio.getSelectedItem().toString();

    double precio = obtenerPrecioServicio(servicioSeleccionado);

    if (precio > 0) {
        txtPrecio.setText(String.valueOf(precio));
    } else {
        txtPrecio.setText("");
    }
}

private boolean fechaValida(Date fechaSeleccionada) {
    Date hoy = new Date();

    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");

    String fechaTexto = formato.format(fechaSeleccionada);
    String hoyTexto = formato.format(hoy);

    int fechaInt = Integer.parseInt(fechaTexto);
    int hoyInt = Integer.parseInt(hoyTexto);

    return fechaInt >= hoyInt;
}

private void mostrarServicios() {
    modeloTabla.setRowCount(0);

    for (int i = 0; i < controladorServicios.getContadorServicios(); i++) {
        Servicio servicio = controladorServicios.obtenerServicio(i);

        Object[] fila = {
            servicio.getIdServicio(),
            servicio.getAuto().getCliente().getNombre(),
            servicio.getAuto().toString(),
            servicio.getTipoServicio(),
            servicio.getPrecio(),
            servicio.getFecha(),
            servicio.getHoraEntrada(),
            servicio.getMetodoPago()
        };

        modeloTabla.addRow(fila);
    }
}

private void limpiarCampos() {
    txtIdServicio.setText(controladorServicios.generarIdServicio());
    cmbAutos.setSelectedIndex(0);
    cmbServicio.setSelectedIndex(0);
    txtPrecio.setText("");
    dcFecha.setDate(null);
    cmbMetodoPago.setSelectedIndex(0);
    actualizarHora();
}

private void guardarServicio() {
    if (cmbAutos.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Debes seleccionar un auto");
        return;
    }

    if (cmbServicio.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Debes seleccionar un servicio");
        return;
    }

    if (txtPrecio.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "El precio no puede estar vacío");
        return;
    }

    if (dcFecha.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Debes seleccionar una fecha");
        return;
    }

    if (!fechaValida(dcFecha.getDate())) {
        JOptionPane.showMessageDialog(this, "La fecha no puede ser del pasado");
        return;
    }

    if (cmbMetodoPago.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Debes seleccionar un método de pago");
        return;
    }

    String idServicio = txtIdServicio.getText();

    String autoSeleccionado = cmbAutos.getSelectedItem().toString();
    String idAuto = autoSeleccionado.substring(0, autoSeleccionado.indexOf(" - "));
    Auto auto = controladorRegistro.buscarAutoPorId(idAuto);

if (auto == null) {
    JOptionPane.showMessageDialog(this, "No se encontró el auto seleccionado");
    return;
}

    String tipoServicio = cmbServicio.getSelectedItem().toString();

    double precio = Double.parseDouble(txtPrecio.getText());

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String fecha = formato.format(dcFecha.getDate());

    actualizarHora();
    String horaEntrada = txtHoraEntrada.getText();

    String metodoPago = cmbMetodoPago.getSelectedItem().toString();

    Servicio servicio = new Servicio(idServicio,auto,tipoServicio,precio,fecha,horaEntrada,metodoPago
    );

    boolean guardado = controladorServicios.agregarServicio(servicio);

    if (guardado) {
        JOptionPane.showMessageDialog(this, "Servicio guardado correctamente");
        mostrarServicios();
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(this, "No hay espacio para más servicios");
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdServicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbAutos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbServicio = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtHoraEntrada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        btnGuardarServicios = new javax.swing.JButton();
        btnActualizarAutos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE SERVICIO");

        jLabel2.setText("ID Servicio:");

        txtIdServicio.setEditable(false);

        jLabel3.setText("Auto");

        cmbAutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Servicio:");

        cmbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbServicio.addActionListener(this::cmbServicioActionPerformed);

        jLabel5.setText("Precio:");

        txtPrecio.setEditable(false);

        jLabel6.setText("Fecha:");

        jLabel7.setText("Hora Entrada:");

        txtHoraEntrada.setEditable(false);

        jLabel8.setText("Metodo de Pago");

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardarServicios.setText("Guardar");
        btnGuardarServicios.addActionListener(this::btnGuardarServiciosActionPerformed);

        btnActualizarAutos.setText("Actulizar Autos");
        btnActualizarAutos.addActionListener(this::btnActualizarAutosActionPerformed);

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaServicios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbMetodoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cmbServicio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(btnGuardarServicios)
                                            .addGap(26, 26, 26)
                                            .addComponent(btnActualizarAutos))
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarAutos)
                    .addComponent(btnGuardarServicios))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarServiciosActionPerformed
        // TODO add your handling code here:
        guardarServicio();
    }//GEN-LAST:event_btnGuardarServiciosActionPerformed

    private void btnActualizarAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAutosActionPerformed
        // TODO add your handling code here:
        cargarAutos();
    }//GEN-LAST:event_btnActualizarAutosActionPerformed

    private void cmbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServicioActionPerformed
        // TODO add your handling code here:
        if (cmbServicio.getSelectedItem() != null) {
        actualizarPrecio();
    }
    }//GEN-LAST:event_cmbServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarAutos;
    private javax.swing.JButton btnGuardarServicios;
    private javax.swing.JComboBox<String> cmbAutos;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JComboBox<String> cmbServicio;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtHoraEntrada;
    private javax.swing.JTextField txtIdServicio;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
