/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Hotel;
import Singleton.DataBaseSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class DatoHotels {
 Connection connection;
    public DatoHotels() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }
    
        public ArrayList<Hotel> fillTargetComboHotel() {
        ArrayList<Hotel> listHotels = new ArrayList<>();
        // Se prepara la consulta SQL para seleccionar todos los datos de la tabla hotels
        String selectSQL = "SELECT * FROM hotels";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            // Se ejecuta la consulta y se obtiene el conjunto de resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el conjunto de resultados
            while (rs.next()) {
                // Se crea un nuevo objeto Hotel con los datos de la fila actual
                Hotel hotelEntry = new Hotel(rs.getInt("id_hotel"), rs.getString("name_hotel"), rs.getString("address_hotel"), rs.getString("classification_hotel"), rs.getString("mob_cons_hotel"), rs.getString("pictures_hotel"), rs.getInt("id_city"));
                // Se añade el objeto Hotel a la lista
                listHotels.add(hotelEntry);
            }
        } catch (SQLException e) {
            // Si ocurre un error, se imprime un mensaje de error y se muestra la pila de errores
            System.out.println("Ocurrió un error al realizar la consulta en la base de datos");
            e.printStackTrace();
        }
        // Se devuelve la lista de hoteles
        return listHotels;
    }
    
    
    
    
    
}
