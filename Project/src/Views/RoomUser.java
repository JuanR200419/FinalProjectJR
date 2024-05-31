package Views;
import Models.Hotel;
import Models.Room;
import Services.HotelsController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class RoomUser extends javax.swing.JFrame {
HotelsController control;
   ArrayList<Room>roomList;
   int id_hotel;
    public RoomUser(ArrayList<Room> roomlist) {
        initComponents();
        this.id_hotel = id_hotel;
        System.out.println(id_hotel);
        this.control = new HotelsController();
        this.roomList  = roomlist;
          
// Obtén el número de registros de la base de datos
        int numRegistros = roomList.size();
        
        // Crea un JPanel para contener las tarjetas
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(numRegistros / 3 + 1, 3, 10, 10));

        PanelPerron.setLayout(new GridLayout(numRegistros / 3 + 1, 3, 10, 10));

        // Crea las tarjetas dinámicamente y añádelas al JPanel
        for (int i = 0; i < numRegistros; i++) {
            // Crea un nuevo JPanel para la tarjeta
            JPanel card = new JPanel();
            card.setBorder(new EmptyBorder(10, 10, 10, 10));  // Agrega un borde vacío para simular un padding
            card.setBackground(Color.WHITE);  // Establece el color de fondo de la tarjeta
            card.setLayout(new BorderLayout());  // Establece el layout de la tarjeta

            // Crea un JLabel para el título de la tarjeta y añádelo al JPanel
            JLabel title = new JLabel("Hotel " + (i + 1));
            title.setFont(new Font("Arial", Font.BOLD, 14));  // Establece la fuente del título
            card.add(title, BorderLayout.NORTH);

            // Crea un JLabel para el contenido de la tarjeta y añádelo al JPanel
            JLabel content = new JLabel(String.valueOf(roomList.get(i).getAmenitiesDetails()) + (i + 1));
            card.add(content, BorderLayout.CENTER);

            // Crea un JTextField para el campo de texto adicional y añádelo al JPanel
            JLabel textField = new JLabel("Texto adicional " + (i + 1));
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
                    System.out.println("Se hizo clic en la tarjeta " + (index ));
                    System.out.println(String.valueOf(roomList.get(index)));
                    
                    
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
        PanelPerron.setLayout(new BorderLayout());
        PanelPerron.add(scrollPane, BorderLayout.CENTER);
        // Actualiza el JPanel para mostrar los nuevos botones
        PanelPerron.revalidate();
        PanelPerron.repaint();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPerron = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPerron.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout PanelPerronLayout = new javax.swing.GroupLayout(PanelPerron);
        PanelPerron.setLayout(PanelPerronLayout);
        PanelPerronLayout.setHorizontalGroup(
            PanelPerronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );
        PanelPerronLayout.setVerticalGroup(
            PanelPerronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(4, 27, 43));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelPerron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(PanelPerron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        LoginView log = new LoginView();
        log.setVisible(true);
        log.setLocationRelativeTo(this);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPerron;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
