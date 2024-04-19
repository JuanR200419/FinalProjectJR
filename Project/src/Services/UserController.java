package Services;

import java.sql.Connection;
import Models.User;
import com.sun.source.tree.BreakTree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import Dao.Dao;
import Models.City;
import Models.Hotel;
import Models.Room;
import Singleton.DataBaseSingleton;

public class UserController {

    //We create an object of the class ConexionMySQL
    Connection connection;
    Dao dao;

    public UserController() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
        this.dao = new Dao();
    }

// User methods
    public void insert(User user) {
        dao.insertUser(user);
    }

    public int selectLogin(String email, String password) {
        return dao.selectLogin(email, password);
    }

    public User searchAdmin(int id) {
        return dao.searchUser(id);
    }

    public void delete(int id) {
        dao.deleteUser(id);
    }

    public void update(User user) {
        dao.updateUser(user);
    }

// hotel methods
    public Hotel searchHotel(int id) {
        return dao.searchHotel(id);
    }
    
    public Hotel searchHotelbyName(String value) {
        return dao.searchHotelbyName(value);
    }

    public void insertHotel(Hotel hotel) {
        dao.insertHotel(hotel);
    }

    public void deleteHotel(int id) {
        dao.deleteHotel(id);
    }

    public void updateHotel(Hotel hotel) {
        dao.updateHotel(hotel);
    }

//room methods  
    public Room searchRoom(int id) {
        return dao.searchRoom(id);
    }

    public void insertRoom(Room room) {
        dao.insertRoom(room);
    }

    public void deleteRoom(int id) {
        dao.deleteRoom(id);
    }

    public void updateRoom(Room room) {
        dao.updateRoom(room);
    }

//fill tables
    public Map<String, Object> selectUsers() {
        return dao.selectUsers();
    }

    public Map<String, Object> selectHotels() {
        return dao.selectHotels();
    }

    public Map<String, Object> selectRooms() {
        return dao.selectRooms();
    }
    public ArrayList<Hotel> fullComboHotel() {
    return dao.fullComboHotel( );
    }
     public ArrayList<City> fullComboCity() {
     return dao.fullComboCity();
     }
}
