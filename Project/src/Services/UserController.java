package Services;

import Connection.ConexionMySQL;
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
import Models.Hotel;
import Models.Room;

public class UserController {

    //We create an object of the class ConexionMySQL
    ConexionMySQL conexion;
    Dao dao;

    public UserController() {
        this.conexion = new ConexionMySQL();
        this.dao = new Dao();

    }
// Metodos del Usuario

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
// Metodos del Hotel

    public Hotel searchHotel(int id) {
        return dao.searchHotel(id);
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

    //Metodos De la Habitacion 
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

// llenar tablas 

    public Map<String, Object> selectUsers() {
        return dao.selectUsers();
    }

    public Map<String, Object> selectHotels() {
        return dao.selectHotels();
    }

    public Map<String, Object> selectRooms() {
        return dao.selectRooms();
    }
}
