/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Dao.DaoReservation;
import Models.Reservation;
import Singleton.DataBaseSingleton;
import java.sql.Connection;

/**
 *
 * @author juan
 */
public class controllerReservation {

    Connection connection;
    DaoReservation dao;

    public controllerReservation() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
        this.dao = new DaoReservation();
    }

    public void insertReservation(Reservation reser) {
        dao.insertReservation(reser);
    }

}
