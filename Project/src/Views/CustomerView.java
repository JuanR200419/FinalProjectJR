/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.UserController;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jilssa
 */
public class CustomerView extends javax.swing.JFrame {

    /**
     * Creates new form CustomerView
     */
    UserController control;
    public CustomerView() {
        initComponents();
              this.setLocationRelativeTo(null);
        control = new UserController();
        fill_table();
    }
    public void fill_table() {
        // Llamamos al método select del controlador de usuario. Este método devuelve un mapa con los nombres de las columnas, el número de columnas y los datos de la tabla.
        Map<String, Object> result = control.selectHotels();

        // Obtenemos los nombres de las columnas del mapa de resultados. Los nombres de las columnas se devuelven como una lista de cadenas.
        List<String> columnNames = (List<String>) result.get("columnNames");

        // Obtenemos los datos de la tabla del mapa de resultados. Los datos de la tabla se devuelven como una lista de listas de objetos. Cada lista interna representa una fila de la tabla y contiene los datos de esa fila.
        List<List<Object>> tableData = (List<List<Object>>) result.get("tableData");

        // Creamos un nuevo modelo de tabla. Un modelo de tabla es un objeto que gestiona los datos de una tabla.
        DefaultTableModel model = new DefaultTableModel();

        // Recorremos la lista de nombres de columnas
        for (String columnName : columnNames) {
            // Agregamos cada nombre de columna al modelo de la tabla. Esto crea las columnas en la tabla.
            model.addColumn(columnName);
        }

        // Recorremos la lista de datos de la tabla
        for (List<Object> rowData : tableData) {
            // Agregamos cada fila de datos al modelo de la tabla. Esto agrega los datos a las columnas correspondientes en la tabla.
            model.addRow(rowData.toArray());
        }

        // Establecemos el modelo en la tabla. Esto actualiza la tabla para mostrar los datos del modelo.
        tbl_hoteles.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoteles = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        txtDateExit = new javax.swing.JFormattedTextField();
        btn_search_rooms = new javax.swing.JButton();
        lblCity = new javax.swing.JLabel();
        txtDateEntry = new javax.swing.JFormattedTextField();
        cbxCity = new javax.swing.JComboBox<>();
        lblDateExit = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblDateEntry1 = new javax.swing.JLabel();
        cbxGuests = new javax.swing.JComboBox<>();
        lblGuests = new javax.swing.JLabel();
        cbxTypeRoom = new javax.swing.JComboBox<>();
        lblTypeRoom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel2.setBackground(new java.awt.Color(4, 27, 43));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_mid.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lohit Devanagari", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Elije tu próximo hospedaje");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(156, 156, 156)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_hoteles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_hoteles);

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("ATRAS");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtDateExit.setBackground(new java.awt.Color(204, 204, 255));
        txtDateExit.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtDateExit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDateExit.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtDateExitInputMethodTextChanged(evt);
            }
        });
        txtDateExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateExitActionPerformed(evt);
            }
        });

        btn_search_rooms.setBackground(new java.awt.Color(0, 153, 255));
        btn_search_rooms.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        btn_search_rooms.setForeground(new java.awt.Color(255, 255, 255));
        btn_search_rooms.setText("VER HABITACIONES");
        btn_search_rooms.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_search_rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_roomsActionPerformed(evt);
            }
        });

        lblCity.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 255, 255));
        lblCity.setText("Ciudad:");

        txtDateEntry.setBackground(new java.awt.Color(204, 204, 255));
        txtDateEntry.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtDateEntry.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDateEntry.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtDateEntryInputMethodTextChanged(evt);
            }
        });

        cbxCity.setBackground(new java.awt.Color(204, 204, 255));
        cbxCity.setForeground(new java.awt.Color(0, 0, 0));
        cbxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbxCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCityItemStateChanged(evt);
            }
        });

        lblDateExit.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        lblDateExit.setForeground(new java.awt.Color(255, 255, 255));
        lblDateExit.setText("Fecha Salida:");

        lblDateEntry1.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        lblDateEntry1.setForeground(new java.awt.Color(255, 255, 255));
        lblDateEntry1.setText("Fecha Entrada:");

        cbxGuests.setBackground(new java.awt.Color(204, 204, 255));
        cbxGuests.setForeground(new java.awt.Color(0, 0, 0));
        cbxGuests.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5" }));
        cbxGuests.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxGuestsItemStateChanged(evt);
            }
        });

        lblGuests.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        lblGuests.setForeground(new java.awt.Color(255, 255, 255));
        lblGuests.setText("Seleccione el número de huespedes:");

        cbxTypeRoom.setBackground(new java.awt.Color(204, 204, 255));
        cbxTypeRoom.setForeground(new java.awt.Color(0, 0, 0));
        cbxTypeRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbxTypeRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTypeRoomItemStateChanged(evt);
            }
        });

        lblTypeRoom.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        lblTypeRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblTypeRoom.setText("Seleccione el tipo de habitación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCity)
                    .addComponent(cbxCity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_search_rooms)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGuests)
                            .addComponent(cbxGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTypeRoom)
                            .addComponent(cbxTypeRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateEntry1)
                            .addComponent(txtDateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateExit)
                            .addComponent(txtDateExit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblGuests)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTypeRoom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxTypeRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDateEntry1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDateExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDateExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        LoginView ven = new LoginView();
        ven.setVisible(true);
        ven.setLocationRelativeTo(this);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btn_search_roomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_roomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search_roomsActionPerformed

    private void txtDateExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateExitActionPerformed

    private void cbxCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCityItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCityItemStateChanged

    private void cbxGuestsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxGuestsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGuestsItemStateChanged

    private void cbxTypeRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTypeRoomItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTypeRoomItemStateChanged

    private void txtDateEntryInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtDateEntryInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateEntryInputMethodTextChanged

    private void txtDateExitInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtDateExitInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateExitInputMethodTextChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btn_search_rooms;
    private javax.swing.JComboBox<String> cbxCity;
    private javax.swing.JComboBox<String> cbxGuests;
    private javax.swing.JComboBox<String> cbxTypeRoom;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblDateEntry1;
    private javax.swing.JLabel lblDateExit;
    private javax.swing.JLabel lblGuests;
    private javax.swing.JLabel lblTypeRoom;
    private javax.swing.JTable tbl_hoteles;
    private javax.swing.JFormattedTextField txtDateEntry;
    private javax.swing.JFormattedTextField txtDateExit;
    // End of variables declaration//GEN-END:variables
}
