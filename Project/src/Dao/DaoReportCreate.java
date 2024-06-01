/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.Hotel;
import Models.ReportAdmin;
import Models.ReportUser;
import Models.Reservation;
import Models.Room;
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
public class DaoReportCreate {

    Connection connection;

    public DaoReportCreate() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }

    public ArrayList<Hotel> searchHotel() {
        String selectSQL = "SELECT * FROM hotels";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Hotel> hotelsList = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id_hotel");
                String nameHotel = rs.getString("name_hotel");
                String address = rs.getString("address_hotel");
                String classification = rs.getString("classification_hotel");
                String modCons = rs.getString("mob_cons_hotel");
                String pictures = rs.getString("pictures_hotel");
                int idCity = rs.getInt("id_city");

                Hotel hotel = new Hotel(id, nameHotel, address, classification, modCons, pictures, idCity);
                hotelsList.add(hotel);
            }
            return hotelsList;

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

//nombre usuario,numero de habiaticon,estado habitacion,
// usuario ,habitacion,estado
    public ArrayList<ReportAdmin> searchHotelWithReservations(int id) {
        String selectSQL = "SELECT h.*, reser.id_reservation, reser.id_user, reser.id_rooom, reser.id_stade_reservation, "
                + "reser.entry_date, reser.exit_date, reser.total_price, u.full_name, r.number_rooom, s.type_stade_reservation "
                + "FROM hotels h "
                + "INNER JOIN rooms r ON h.id_hotel = r.id_hotel "
                + "INNER JOIN reservations reser ON r.id_rooom = reser.id_rooom "
                + "INNER JOIN users u ON reser.id_user = u.id_user "
                + "INNER JOIN stades_reservations s ON reser.id_stade_reservation = s.id_stade_reservation "
                + "WHERE h.id_hotel = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<ReportAdmin> reports = new ArrayList<>();

            while (rs.next()) {
                ReportAdmin report = new ReportAdmin(
                        rs.getInt("id_reservation"), // numberReser
                        rs.getString("full_name"), // userName
                        rs.getInt("id_user"), // idUser
                        rs.getInt("number_rooom"), // numberRoom
                        rs.getString("entry_date"), // entryDate
                        rs.getString("exit_date"), // exitDate
                        rs.getString("type_stade_reservation"), // estado
                        rs.getDouble("total_price") // price
                );
                reports.add(report);
            }
            return reports;

        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ReportUser> searchRerverWithUser(int id) {
    String selectSQL = "SELECT u.full_name, r.number_rooom, reser.total_price, reser.entry_date, reser.exit_date "
            + "FROM users u "
            + "INNER JOIN reservations reser ON u.id_user = reser.id_user "
            + "INNER JOIN rooms r ON reser.id_rooom = r.id_rooom "
            + "INNER JOIN stades_reservations s ON reser.id_stade_reservation = s.id_stade_reservation "
            + "WHERE u.id_user = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<ReportUser> reports = new ArrayList<>();

        while (rs.next()) {
            String nameUser = rs.getString("full_name");
            String numRoom = rs.getString("number_rooom");
            String priceTotal = rs.getString("total_price");
            String entryDate = rs.getString("entry_date");
            String exitDate = rs.getString("exit_date");

            ReportUser report = new ReportUser(nameUser, numRoom, priceTotal, entryDate, exitDate);
            reports.add(report);
        }
        return reports;

    } catch (SQLException e) {
        System.out.println("Ocurrió un error al realizar la selección en la base de datos");
        e.printStackTrace();
    }
    return null;
}

}
