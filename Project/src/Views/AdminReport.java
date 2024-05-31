/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Hotel;
import Models.ReportAdmin;
import Models.Reservation;
import Services.ReportAdminController;
import com.itextpdf.text.DocumentException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author juan
 */
public class AdminReport extends javax.swing.JFrame {
ReportAdminController control;

    public AdminReport() {
        initComponents();
        this.control = new ReportAdminController();
        ArrayList<Hotel>  listHotels = control.searchHotel();
        crearPaneles(listHotels);
    }
    
    private void crearPaneles(ArrayList<Hotel>  listHotels){
    
         int numRegistros= listHotels.size();
// Obtén el número de registros de la base de datos
        
        
        // Crea un JPanel para contener las tarjetas
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(numRegistros / 3 + 1, 3, 10, 10));

        PanelPrincipal.setLayout(new GridLayout(numRegistros / 3 + 1, 3, 10, 10));

        // Crea las tarjetas dinámicamente y añádelas al JPanel
        for (int i = 0; i < numRegistros; i++) {
            // Crea un nuevo JPanel para la tarjeta
            JPanel card = new JPanel();
            card.setBorder(new EmptyBorder(10, 10, 10, 10));  // Agrega un borde vacío para simular un padding
            card.setBackground(Color.WHITE);  // Establece el color de fondo de la tarjeta
            card.setLayout(new BorderLayout());  // Establece el layout de la tarjeta

            // Crea un JLabel para el título de la tarjeta y añádelo al JPanel
            JLabel title = new JLabel("HOTEL " + (i + 1));
            title.setFont(new Font("Arial", Font.BOLD, 14));  // Establece la fuente del título
            card.add(title, BorderLayout.NORTH);

            // Crea un JLabel para el contenido de la tarjeta y añádelo al JPanel
            JLabel content = new JLabel(String.valueOf(listHotels.get(i).getNameHotel()) + (i + 1));
            card.add(content, BorderLayout.CENTER);

            // Crea un JTextField para el campo de texto adicional y añádelo al JPanel
            JLabel textField = new JLabel(String.valueOf(listHotels.get(i).getClassification()) );
            card.add(textField, BorderLayout.SOUTH);

            // Crea una variable final que contenga el valor de i
            final int index = i;

            // Crea un borde compuesto con un borde vacío y un borde de línea
            Border padding = new EmptyBorder(10, 10, 10, 10);
            Border borderLine = BorderFactory.createLineBorder(Color.BLACK, 1);
            Border border = new CompoundBorder(borderLine, padding);
            card.setBorder(border);

            // Agrega un MouseListener al JPanel
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Este código se ejecutará cuando se haga clic en el JPanel
                    System.out.println("Se hizo clic en la tarjeta " + (index+1 ));
                    
                  ArrayList<ReportAdmin> listReservation= control.searchHotelWithReservations(listHotels.get(index).getId());
                    try {
                        control.createRepor(listReservation);
                    } catch (FileNotFoundException | DocumentException ex) {
                        JOptionPane.showConfirmDialog(null, "No se pudo crear el reporte");
                    } catch (IOException ex) {
                     JOptionPane.showConfirmDialog(null, "No se pudo crear el reporte");
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // Cambia el color del borde a azul cuando el ratón entra en el JPanel
                    Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
                    Border compound = new CompoundBorder(blueBorder, padding);
                    card.setBorder(compound);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Cambia el color del borde al color inicial cuando el ratón sale del JPanel
                    card.setBorder(border);
                }
            });

            // Cambia el cursor a un puntero de mano cuando el ratón está sobre el JPanel
            card.setCursor(Cursor.getDefaultCursor().getPredefinedCursor(Cursor.HAND_CURSOR));

            cardsPanel.add(card);
        }

        // Crea un JScrollPane y añade el JPanel a él
        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        //   scrollPane.setPreferredSize(new Dimension(PanelPerron.getWidth(), PanelPerron.getHeight()));
        // Añade el JScrollPane a tu panel principal
        PanelPrincipal.setLayout(new BorderLayout());
        PanelPrincipal.add(scrollPane, BorderLayout.CENTER);
        // Actualiza el JPanel para mostrar los nuevos botones
        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();
        
    
    
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelAdmin.setBackground(new java.awt.Color(4, 27, 43));
        PanelAdmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lohit Devanagari", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORT FOR ADMIN");
        PanelAdmin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 240, -1));

        PanelPrincipal.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        PanelAdmin.add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 670, 430));

        btnBack.setBackground(new java.awt.Color(0, 0, 51));
        btnBack.setFont(new java.awt.Font("Lohit Devanagari", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("ATRAS");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        PanelAdmin.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        AdministrationView ven = new AdministrationView();
        ven.setVisible(true);
        ven.setLocationRelativeTo(this);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAdmin;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
