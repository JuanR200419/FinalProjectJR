/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Reservation;
import Singleton.DataBaseSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class DaoReservation {

    Connection connection;

    public DaoReservation() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }


public void insertReservation(Reservation reser) {
    String entradaFecha = reser.getEntryDate();
    String entradaSalida = reser.getExitDate();
    
    boolean very = verifyDate(reser);
    if (very) {
        String insertSQL = "INSERT INTO reservations (id_reservation, id_user, id_room, id_stade_reservation, entry_date, exit_date, total_price) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, reser.getId());
            pstmt.setInt(2, reser.getUser_id());
            pstmt.setInt(3, reser.getRoom_id());
            pstmt.setInt(4, reser.getState());
            pstmt.setString(5, entradaFecha);
            pstmt.setString(6, entradaSalida);
            pstmt.setDouble(7, reser.getTotalPrice());

            // Ejecutamos la consulta
            int rowsAffected = pstmt.executeUpdate();

            // Verificamos si la inserción fue exitosa
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa");
                JOptionPane.showMessageDialog(null, "Se ha registrado con éxito ");
            } else {
                System.out.println("No se pudo insertar los datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la inserción en la base de datos");
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "La fecha de entrada no puede ser anterior a la fecha de Salida");
    }
}


private boolean verifyDate(Reservation reser) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    try {
        LocalDate dateEntry = LocalDate.parse(reser.getEntryDate(), formatter);
        LocalDate dateExit = LocalDate.parse(reser.getExitDate(), formatter);
        return dateEntry.isBefore(dateExit);
    } catch (DateTimeParseException e) {
        System.err.println("Error al parsear la fecha: " + e.getMessage());
        return false;
    }
}

}
