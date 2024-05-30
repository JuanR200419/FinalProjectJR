/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Dao.Dao;
import Dao.DatoHotels;
import Models.Hotel;
import Models.Room;
import Singleton.DataBaseSingleton;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class HotelsController {
    Connection connection;
    DatoHotels dao;
    public HotelsController() {
                this.connection = DataBaseSingleton.getInstance().getConnection();
    this.dao = new DatoHotels();
    }
    
      public ArrayList<Room> fillTargetComboHotel( int id_hotel) {
      return dao.fillTargetRoom(id_hotel);
      }
      
      
     
    
      
      
    
}
